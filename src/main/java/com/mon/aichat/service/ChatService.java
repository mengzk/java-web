package com.mon.aichat.service;

import com.mon.aichat.model.dto.RobotDTO;
import com.mon.aichat.modules.exception.CustomException;
import okhttp3.Request;
import org.springframework.stereotype.Service;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 对话服务
 */
@Service
public class ChatService {

    /**
     * 对话
     */
    public RobotDTO invoke(String str) throws CustomException {
        return null;
    }

    /**
     * 对话
     */
    public String sse(String msg) {
        Request.Builder builder = new Request.Builder().url("http://127.0.0.1:8080/sse/chat");
        builder.build();
//        OkResult<String> result = OkRequest.request();

        return null;
    }
}
