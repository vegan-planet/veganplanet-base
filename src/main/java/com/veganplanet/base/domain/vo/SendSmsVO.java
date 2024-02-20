package com.veganplanet.base.domain.vo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @date 2024/1/16 15:28
 */
@Data
public class SendSmsVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *手机号
     */
    @NotEmpty( message = "手机号不能为空")
    private String phone;
    /**
     *验证码类型
     */
    private String smsType;
}
