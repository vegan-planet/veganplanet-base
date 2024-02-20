package com.veganplanet.base.controller;

import com.veganplanet.base.domain.vo.SendSmsVO;
import com.veganplanet.base.service.BaseMessageService;
import com.veganplanet.common.core.response.Res;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 素食星球基础发送消息通知服务
 *
 * @date 2024/1/16 15:25
 */
@Validated
@RestController
@RequestMapping("/baseMessage")
public class BaseMessageController {

    @Resource
    BaseMessageService baseMessageService;


    /**
     * <p>发送短信</p>
     * @param sendSmsVO 发送短信
     * @return  类型 {@link Res}
     * @author wxh_work@163.com
     * @date 2022/11/2 12:20
     */
    @PostMapping(value = "/sendSms")
    public Res sendSms(@Valid @RequestBody SendSmsVO sendSmsVO) {
        return baseMessageService.sendSms(sendSmsVO);
    }

}
