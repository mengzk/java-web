package com.mon.aichat.service;

import com.mon.aichat.model.body.RobotBody;
import com.mon.aichat.model.dto.RobotDTO;
import com.mon.aichat.model.entity.ChatChoice;
import com.mon.aichat.modules.api.Chat;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import com.mon.aichat.modules.network.OkResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 对话服务
 */
@Service
public class ChatService2 {
    @Autowired
    UseRecordService service;

    Map<String, String> devices = new LinkedHashMap();

    public RobotDTO take(RobotBody body) throws AppException {
        // 获取会话消息id
//        OkResult res = Chat.completion(body.query);
        String cid = "";
        if(devices.containsKey(body.sn)) {
            System.out.println(body.sn + " - " + devices.get(body.sn));
            String[] arr = devices.get(body.sn).split("&");
            if(Long.parseLong(arr[0]) < System.currentTimeMillis() - 1000 * 60 * 3) {
                cid = arr[1];
            } else {
                devices.remove(body.sn);
            }
        }
        OkResult res = Chat.assistant("baaa696e5a564afe5e4ce49236e852b0.dV3gTIO7SasX8K6H", cid, body.query);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        ChatChoice data = (ChatChoice) res.data;
        List<ChatChoice.ChoicesDTO> list = data.getChoices();
        if(list == null) {
            return null;
        }
        // 保存消息会话id
//        System.out.println("-----> " + data.request_id);
        devices.put(body.sn, System.currentTimeMillis() + "&" + data.request_id);
        return RobotDTO.nlp(list);
    }
    public RobotDTO invoke(RobotBody msg) throws CustomException {
        // 获取会话消息id
        OkResult res = Chat.invoke("baaa696e5a564afe5e4ce49236e852b0.dV3gTIO7SasX8K6H", msg.query);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        System.out.println(res.data.toString());
        ChatChoice data = (ChatChoice) res.data;
        // 保存消息会话id
        return RobotDTO.nlp(data.getChoices());
    }
}
