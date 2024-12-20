package com.mon.aichat.modules.network;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;

public class OkEventSource {
    private final static String DOMAIN = "https://open.bigmodel.cn/api";
    private static final OkHttpClient client = OkClient.sse();

    public static void execute(Object params, OkEventSourceListener listener) {

        String json = params != null ? new Gson().toJson(params) : "";
        RequestBody body = RequestBody.create(json, OkClient.MEDIA_JSON);

        Request request = new Request.Builder().url(DOMAIN).post(body).build();

        EventSource.Factory factory = EventSources.createFactory(client);
        factory.newEventSource(request, listener);
        listener.onDownEvent();
    }

    public static void enqueue() {

    }



}
