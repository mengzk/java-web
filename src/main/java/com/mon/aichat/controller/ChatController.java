package com.mon.aichat.controller;

import com.alibaba.druid.sql.dialect.sqlserver.parser.SQLServerLexer;
import com.mon.aichat.model.body.ChatSSE;
import com.mon.aichat.model.body.RobotBody;
import com.mon.aichat.model.dto.RobotDTO;
import com.mon.aichat.model.dto.SseChatDTO;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.modules.network.ChatSseEmitter;
import com.mon.aichat.modules.network.OkEventSource;
import com.mon.aichat.modules.network.OkEventSourceListener;
import com.mon.aichat.service.ChatService;
import com.zhipu.oapi.service.v4.model.ModelData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 对话
 */

@RestController
@RequestMapping("/dialogue")
public class ChatController {
    @Autowired
    ChatService service;

    @GetMapping(path = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public void test(HttpServletResponse response) {
        System.out.println("------> see: ");
    }

    @PostMapping(path = "/invoke", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter invoke(@RequestBody() ChatSSE body, HttpServletResponse res) {
        ChatSseEmitter sseEmitter = new ChatSseEmitter();
        ModelData data = service.sse(body);
        if (data == null) {
            sseEmitter.error("1011", "数据异常");
        } else {
            sseEmitter.sendMsg(SseChatDTO.start(body.id, data.getModel(), data.getCreated()));

            sseEmitter.sendMsg(new SseChatDTO(data, body.id));

            sseEmitter.sendMsg(SseChatDTO.stop(body.id, data.getModel(), data.getCreated()));
            sseEmitter.complete();
        }
        return sseEmitter.getEmitter();
    }

    /**
     * 智能体
     */
    @RequestMapping(value = "assistant", method = RequestMethod.POST)
    public ResultBody take(@RequestBody() RobotBody msg) throws Exception {
        return ResultBody.success(service.assistant(msg));
    }

    /**
     * 大模型
     */
    @RequestMapping(value = "completion", method = RequestMethod.POST)
    public ResultBody completion(@RequestBody() RobotBody msg) throws Exception {
        return ResultBody.success(service.completion(msg));
    }

    /**
     *
     */
    @RequestMapping(value = "chat", method = RequestMethod.POST)
    public ResultBody invoke(@RequestBody() RobotBody msg) throws Exception {
        return ResultBody.success(service.invoke(msg));
    }
}
