package com.veganplanet.base.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.veganplanet.base.domain.entity.BaseImage;
import com.veganplanet.base.service.BaseService;
import com.veganplanet.user.api.dto.UserDTO;
import com.veganplanet.user.api.vo.UserVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sysBase")
public class BaseController {

    @Resource
    private BaseService baseService;

    @PostMapping("/getBaseInfo")
    @SentinelResource(value = "getBaseInfo")
    public UserDTO getBaseInfo(@RequestBody UserVO userVO) {
        return baseService.getBaseInfo(userVO);
    }

    @PostMapping("/baseImageInsert")
    @SentinelResource(value = "baseImageInsert")
    public BaseImage baseImageInsert(@RequestBody BaseImage baseImage) {
        return baseService.baseImageInsert(baseImage);
    }
}
