package com.mon.aichat.controller;

import com.mon.aichat.model.body.ChatBody;
import com.mon.aichat.model.dto.SseChatDTO;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.modules.network.sse.ChatSseEmitter;
import com.mon.aichat.service.ChatService;
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
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService service;

    @GetMapping(path = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public void test(HttpServletResponse response) {
        System.out.println("------> see: ");
    }

    @PostMapping(path = "/invoke", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter invoke(@RequestBody() ChatBody body, HttpServletResponse res) {
        ChatSseEmitter sseEmitter = new ChatSseEmitter();
        String data = service.sse(body.msg);
        if (data == null) {
            sseEmitter.error("1011", "数据异常");
        } else {
            sseEmitter.sendMsg(SseChatDTO.start(body.id, data, System.currentTimeMillis()));

            sseEmitter.sendMsg(new SseChatDTO(data, body.id));

            sseEmitter.sendMsg(SseChatDTO.stop(body.id, data, System.currentTimeMillis()));
            sseEmitter.complete();
        }
        return sseEmitter.getEmitter();
    }

    /**
     *
     */
    @RequestMapping(value = "chat", method = RequestMethod.POST)
    public ResultBody invoke(@RequestBody() ChatBody body) throws Exception {
        return ResultBody.success(service.invoke(body.msg));
    }
}
