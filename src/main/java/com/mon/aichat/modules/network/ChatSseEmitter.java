package com.mon.aichat.modules.network;

import com.google.gson.Gson;
import com.mon.aichat.model.dto.SseErrDTO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class ChatSseEmitter {

    private SseEmitter emitter;

    public ChatSseEmitter() {
        emitter = new SseEmitter(10000L);

        emitter.onCompletion(() -> {
            System.out.println("ChatSseEmitter ------> onCompletion: ");
        });

        emitter.onTimeout(() -> {
            System.out.println("ChatSseEmitter ------> onTimeout: ");
        });

        emitter.onError((e) -> {
            System.out.println("ChatSseEmitter ------> onError: "+e.getMessage());
        });
    }

    public void sendMsg(Object body) {
        Gson gson = new Gson();
        try {
            SseEmitter.SseEventBuilder msg = SseEmitter.event().name("data").data(gson.toJson(body));
            emitter.send(msg);
//            msg = SseEmitter.event().name("msg").data(gson.toJson(body));
//            emitter.send(msg);
        } catch (Exception e) {
            System.out.println("ChatSseEmitter ------> sendMsg: "+e.getMessage());
        }
        // 数据发送完成后，关闭连接
//        emitter.complete();
    }

    public void error(String code, String text) {
        Gson gson = new Gson();
        try {
            SseEmitter.SseEventBuilder msg = SseEmitter.event().name("error").data(gson.toJson(new SseErrDTO(code, text)));
            emitter.send(msg);
        } catch (Exception e) {
            System.out.println("ChatSseEmitter ------> error: "+e.getMessage());
        }
        complete();
    }

    // 数据发送完成后，关闭连接
    public void complete() {
        emitter.complete();
    }

    public SseEmitter getEmitter() {
        return emitter;
    }
}
