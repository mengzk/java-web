package com.mon.aichat.controller;

import com.mon.aichat.model.body.KnowledgeBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 知识库
 */

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    KnowledgeService service;

    // 创建知识库
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() KnowledgeBody body) throws Exception {
        return ResultBody.success(service.create(body));
    }

    // 知识库列表
    @RequestMapping(value = "list")
    public ResultBody list(@RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
        return ResultBody.success(service.list(page, size));
    }

    // 知识库详细
    @RequestMapping(value = "detail")
    public ResultBody detail(@RequestParam("id") int id) throws Exception {
        return ResultBody.success(service.detail(id));
    }

    // 编辑知识库
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody update(@RequestBody() KnowledgeBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    // 知识库删除
    @RequestMapping(value = "delete")
    public ResultBody delete(@RequestParam("id") int id) throws Exception {
        return ResultBody.success(service.delete(id));
    }


    // 知识库容量
    @RequestMapping(value = "capacity")
    public ResultBody capacity() throws Exception {
        return ResultBody.success(service.capacity());
    }

    /**
     * ---------- 文档知识库 ----------
     */
    // 上传文件构建知识库
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResultBody upload(@RequestParam("file") MultipartFile file, @RequestParam("purpose") String purpose, @RequestParam("kid") String kid) throws Exception {
        return ResultBody.success(service.upload(file, purpose, kid));
    }

    // 上传文件构建知识库
//    @RequestMapping(value = "uploads", method = RequestMethod.POST)
//    public ResultBody uploads(@RequestParam("files") List<MultipartFile> files) throws Exception {
//        return ResultBody.success(service.upload());
//    }

    // 知识库文件列表
    @RequestMapping(value = "docList")
    public ResultBody docList(@RequestParam("purpose") String purpose, @RequestParam("page") Integer page, @RequestParam("kid") String kid) throws Exception {

        return ResultBody.success(service.docList(purpose, page, kid));
    }

    // 知识库文件详细
    @RequestMapping(value = "docInfo")
    public ResultBody docInfo(@RequestParam("id") String id) throws Exception {
        return ResultBody.success(service.docDetail(id));
    }

    // 编辑文件知识库
    @RequestMapping(value = "docUpdate", method = RequestMethod.POST)
    public ResultBody docEdit(@RequestParam("id") String id) throws Exception {
        return ResultBody.success(service.docUpdate(id));
    }

    // 知识库文件删除
    @RequestMapping(value = "docDelete")
    public ResultBody docDelete(@RequestParam("id") String id) throws Exception {
        return ResultBody.success(service.docDelete(id));
    }

}
