package com.veganplanet.base.service;

import com.veganplanet.base.domain.vo.SendSmsVO;
import com.veganplanet.common.core.response.Res;

/**
 * 发送消息
 *
 * @author wxh_work@163.com
 * @date 2022/11/2 12:27
 */
public interface BaseMessageService {

    /**
     * <p>发现短信</p>
     * @author wxh_work@163.com
     * @date 2022/11/2 14:07
     * @param
     * @return
     */
    Res sendSms(SendSmsVO sendSmsVO);
}
