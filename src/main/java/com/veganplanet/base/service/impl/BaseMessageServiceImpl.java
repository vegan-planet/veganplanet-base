package com.veganplanet.base.service.impl;

import com.veganplanet.base.domain.vo.SendSmsVO;
import com.veganplanet.base.service.BaseMessageService;
import com.veganplanet.common.core.response.Res;
import com.veganplanet.common.core.response.ServiceStatus;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @date 2024/1/16 15:27
 */
@Slf4j
@Service
public class BaseMessageServiceImpl implements BaseMessageService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;
    /**
     * <p>发送短信</p>
     * @author wxh_work@163.com
     * @date 2022/11/2 14:08
     * @param
     * @return
     */
    @Override
    public Res sendSms(SendSmsVO sendSmsVO) {
        //生成验证码
        String codeNumber = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));
        //模拟固定验证码；123456
        codeNumber="123456";
        //是否发送短信验证
        Boolean verificationSendSms = this.checkSendSms(sendSmsVO.getPhone(),codeNumber,sendSmsVO.getSmsType());
        if (Boolean.FALSE.equals(verificationSendSms)) {
            return Res.get(ServiceStatus.GET.NOT_FOUND,"验证码已发送,请注意查收!");
        }
        //发送短信业
        log.info("手机号:{}模拟发送短信,验证码为:{}",sendSmsVO.getPhone(),codeNumber);
        return Res.ok("发送短信成功");
    }

    /**
     * <p>是否发送短信验证</p>
     * @author wxh_work@163.com
     * @date 2022/11/3 11:45
     * @param
     * @return
     */
    private boolean checkSendSms(String mobile, String codeNumber,String smsType) {
        String loginSmsRedisKey = smsType+"_"+mobile;
        final Boolean hasKey = this.redisTemplate.hasKey(loginSmsRedisKey);
        if (Boolean.TRUE.equals(hasKey)) {
            return Boolean.FALSE;
        }
        this.redisTemplate.opsForValue().set(loginSmsRedisKey, codeNumber, 5, TimeUnit.MINUTES);
        return Boolean.TRUE;
    }
}
