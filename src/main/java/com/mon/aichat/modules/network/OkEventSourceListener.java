package com.mon.aichat.modules.network;

import com.mon.aichat.model.body.ChatSSE;
import jakarta.servlet.http.HttpServletResponse;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CountDownLatch;

public class OkEventSourceListener extends EventSourceListener {
    private static final String TAG = "OkEventSourceListener";

    private CountDownLatch downLatch = new CountDownLatch(1);
    private HttpServletResponse response;
    private ChatSSE chat;

    public OkEventSourceListener(ChatSSE chat, HttpServletResponse response) {
        this.response = response;
        this.chat = chat;
    }

    @Override
    public void onOpen(@NotNull EventSource es, @NotNull Response res) {
//        super.onOpen(es, res);
        System.out.println(TAG + " ------> onOpen: " + chat);

        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
    }

    @Override
    public void onEvent(@NotNull EventSource eventSource, @Nullable String id, @Nullable String type, @NotNull String data) {
//        super.onEvent(eventSource, id, type, data);
        try {
            System.out.println(TAG + " ------> onEvent: " + data);
        } catch (Exception e) {
            e.fillInStackTrace();
            downLatch.countDown();
        }
    }

    @Override
    public void onClosed(@NotNull EventSource eventSource) {
//        super.onClosed(eventSource);
        System.out.println(TAG + " ------> onClosed: " + chat);
        downLatch.countDown();
    }

    @Override
    public void onFailure(@NotNull EventSource eventSource, @Nullable Throwable t, @Nullable Response response) {
//        super.onFailure(eventSource, t, response);
        System.out.println(TAG + " ------> onFailure: " + chat);
        downLatch.countDown();
    }

    public void onDownEvent() {
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
