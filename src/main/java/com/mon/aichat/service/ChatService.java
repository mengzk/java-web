package com.mon.aichat.service;

import com.mon.aichat.model.body.ChatSSE;
import com.mon.aichat.model.body.RobotBody;
import com.mon.aichat.model.dto.RobotDTO;
import com.mon.aichat.modules.api.BigModel;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import com.zhipu.oapi.service.v4.model.ChatMessage;
import com.zhipu.oapi.service.v4.model.ChatMessageRole;
import com.zhipu.oapi.service.v4.model.ModelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 对话服务
 */
@Service
public class ChatService {
    @Autowired
    UseRecordService service;

    Map<String, List<ChatMessage>> devices = new LinkedHashMap();
    Map<String, Long> devicesTag = new LinkedHashMap();


    /**
     *智能体
     * @param body
     */
    public RobotDTO assistant(RobotBody body) throws AppException {
        // 获取会话消息id
//        OkResult res = Chat.completion(body.query);

        // 保存消息会话id
//        System.out.println("-----> " + data.request_id);
        return null;
    }

    /**
     * 大模型
     * @param body
     */
    public RobotDTO completion(RobotBody body) throws CustomException {
        // 获取会话消息id
        // 保存消息会话id
        return null;
    }

    /**
     *
     * @param body
     */
    public RobotDTO invoke(RobotBody body) throws CustomException {
        // 获取会话消息id
        List<ChatMessage> msgs = null;

        if(devices.containsKey(body.sn)) {
            Long lastTime = devicesTag.get(body.sn);
            if(System.currentTimeMillis() - lastTime < 30000) {
                msgs = devices.get(body.sn);
            }
        }
        if(msgs == null) {
            msgs = new ArrayList<>();
        }
        msgs.add(new ChatMessage(ChatMessageRole.USER.value(), body.query));
        ModelData res = BigModel.invoke(msgs);
        if(res == null) {
            return null;
        }
        if(!res.getChoices().isEmpty()) {
            msgs.add(res.getChoices().get(0).getMessage());
            devices.put(body.sn, msgs);
        }
        devicesTag.put(body.sn, System.currentTimeMillis());
        return RobotDTO.nlp2(res.getChoices());
    }


    /**
     *
     * @param body
     */
    public ModelData sse(ChatSSE body) {
        // 获取会话消息id
        List<ChatMessage> msgs = null;

        if(devices.containsKey(body.device_id)) {
            Long lastTime = devicesTag.get(body.device_id);
            if(System.currentTimeMillis() - lastTime < 30000) {
//                msgs = devices.get(body.device_id);
            }
        }
        if(msgs == null) {
            msgs = new ArrayList<>();
        }
        for (int i = 0; i < body.messages.size(); i++) {
            ChatSSE.Msg msg = body.messages.get(i);
            msgs.add(new ChatMessage(msg.role, msg.content));
        }
        ModelData res = BigModel.invoke(msgs);
        if(res == null) {
            return null;
        }
        if(!res.getChoices().isEmpty()) {
            msgs.add(res.getChoices().get(0).getMessage());
            devices.put(body.device_id, msgs);
        }
        devicesTag.put(body.device_id, System.currentTimeMillis());
        return res;
    }
}
