package com.mdx.hubing.module.network;

import com.mdx.hubing.model.body.ChatBody;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Meng
 * Date: 2024-05-08
 * Desc:
 * header: Authorization: ''
 */
public class Chat {

    public static void request() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "1234567890");
//        RequestOption<ChatBody> option = new RequestOption<>("http://192.168.243.92:8093/file/download");
//        option.headers = headers;
//
//        option.method = "GET";
//        option.params = new ChatBody();
//        OkRequest.request(option);

    }
}
