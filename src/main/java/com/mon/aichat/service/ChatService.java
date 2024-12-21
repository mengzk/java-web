package com.mon.aichat.service;

import com.mon.aichat.model.dto.RobotDTO;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import com.zhipu.oapi.service.v4.model.ModelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
    public ModelData chat(String msg) throws AppException {
        return null;
    }
}
