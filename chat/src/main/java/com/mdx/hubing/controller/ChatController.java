package com.mdx.hubing.controller;

import com.mdx.hubing.module.network.Chat;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 知识库
 */

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService service;

    // 向量模版列表
    @RequestMapping(value = "embedding", method = RequestMethod.POST)
    public ResultBody embedding() throws Exception {
        return ResultBody.success(0);
    }

    // 知识库删除
    @RequestMapping(value = "delete")
    public ResultBody delete() throws Exception {
        return ResultBody.success(0);
    }

    // 编辑知识库
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody update() throws Exception {
        return ResultBody.success(0);
    }

    // 创建知识库
    @RequestMapping(value = "knowledge", method = RequestMethod.POST)
    public ResultBody knowledge() throws Exception {
        System.out.println("========> post");
        Chat.request();
        return ResultBody.success(0);
    }

    // 知识库列表
    @RequestMapping(value = "knowledge")
    public ResultBody list() {
        System.out.println("========> get");
        return ResultBody.success(0);
    }

    // 知识库详细
    @RequestMapping(value = "detail")
    public ResultBody detail() throws Exception {
        return ResultBody.success(0);
    }

    // 知识库容量
    @RequestMapping(value = "capacity")
    public ResultBody capacity() throws Exception {
        return ResultBody.success(0);
    }

    // 上传文档构建知识库
    @RequestMapping(value = "uploadDoc")
    public ResultBody uploadDoc() throws Exception {
        return ResultBody.success(0);
    }

    // 编辑文档知识库
    @RequestMapping(value = "document", method = RequestMethod.POST)
    public ResultBody document() throws Exception {
        return ResultBody.success(0);
    }

    // 知识库中知识列表
    @RequestMapping(value = "document")
    public ResultBody documentList() throws Exception {
        return ResultBody.success(0);
    }

}
