package com.mon.aichat.modules.api;

import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BigModel {
    private static final String API_KEY = "1a657529c9c5e6c53b13662116121a1d.XWP6YQtmKuM4hiCd";
    private static final ClientV4 client = new ClientV4.Builder(API_KEY).networkConfig(30, 30, 30, 30, TimeUnit.SECONDS).build();
    private static final String requestId = "ql-%d";


    public static ModelData assistant(String msg, List<ChatMessage> msgs) {
        return null;
    }

    public static ModelData completion(String msg) {
        return null;
    }

    public static ModelData invokeS(List<ChatMessage> msg) {

        ModelData data = request(Constants.invokeMethodSse, msg);
        System.out.println(data);
        return data;
    }

    public static ModelData invoke(List<ChatMessage> msg) {
        ModelData data = request(Constants.invokeMethod, msg);
        return data;
    }

    public static ModelData request(String method, List<ChatMessage> msgs) {
        try {
//            List<ChatMessage> messages = new ArrayList<>();
//            messages.add(new ChatMessage(ChatMessageRole.USER.value(), msg));
            System.out.println("messages:" + msgs);
            String id = String.format(requestId, System.currentTimeMillis());
            ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                    .model(Constants.ModelChatGLM4)
                    .stream(Boolean.FALSE)
                    .invokeMethod(method)
                    .messages(msgs)
                    .requestId(id)
                    .build();

            ModelApiResponse response = client.invokeModelApi(chatCompletionRequest);
            if (response != null) {
                System.out.println("response:" + response.getCode() + ", " + response.getMsg());
                return response.getData();
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getLocalizedMessage());
        }
        System.out.println("request result: null");
        return null;
    }
}
