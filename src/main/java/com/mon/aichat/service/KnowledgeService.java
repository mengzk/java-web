package com.mon.aichat.service;

import com.mon.aichat.model.body.KnowledgeBody;
import com.mon.aichat.model.entity.Capacity;
import com.mon.aichat.model.entity.KnowEntity;
import com.mon.aichat.model.entity.ListEntity;
import com.mon.aichat.modules.api.Knowledge;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import com.mon.aichat.modules.network.OkResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 知识库服务
 */
@Service
public class KnowledgeService {

    Knowledge knowledge;

    public KnowledgeService() {
        knowledge = new Knowledge();
    }

    public int create(KnowledgeBody body) throws AppException {
        OkResult res = knowledge.create(body);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public ListEntity<KnowEntity> list(int page, int size) throws AppException {
        OkResult res = knowledge.list(page, size);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return (ListEntity<KnowEntity>) res.data;
    }

    public int detail(int id) throws AppException {
        OkResult res = knowledge.detail(id);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public int update(KnowledgeBody body) throws AppException {
        OkResult res = knowledge.update(body);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public int delete(int id) throws AppException {
        OkResult res = knowledge.delete(id);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public Capacity capacity() throws AppException {
        OkResult res = knowledge.capacity();
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return (Capacity) res.data;
    }

    public int upload(MultipartFile file, String purpose, String kid) throws AppException {
        OkResult res = knowledge.upload(file, purpose, kid);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public int docList(String purpose, Integer page, String kid) throws AppException {
        OkResult res = knowledge.docList(purpose, page, kid);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public int docDetail(String id) throws AppException {
        OkResult res = knowledge.docDetail(id);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public int docUpdate(String id) throws AppException {
        OkResult res = knowledge.docUpdate(id);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

    public int docDelete(String id) throws AppException {
        OkResult res = knowledge.docDelete(id);
        if (res.code != 0) {
            throw new CustomException(res.code, res.msg);
        }
        return 0;
    }

}
