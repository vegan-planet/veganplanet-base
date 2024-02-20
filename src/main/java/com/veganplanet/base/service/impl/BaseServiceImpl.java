package com.veganplanet.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.veganplanet.base.domain.entity.BaseImage;
import com.veganplanet.base.mapper.BaseImageMapper;
import com.veganplanet.base.service.BaseService;
import com.veganplanet.user.api.UserRpcService;
import com.veganplanet.user.api.dto.UserDTO;
import com.veganplanet.user.api.vo.UserVO;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RefreshScope
@Service
public class BaseServiceImpl extends ServiceImpl<BaseImageMapper,BaseImage> implements BaseService {

    @DubboReference(protocol = "dubbo", version = "2.0.0", retries = 3, check = false, timeout = 60000)
    private UserRpcService userService;

    @Override
    public UserDTO getBaseInfo(UserVO userVO) {
        return userService.getUserInfo(userVO);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public BaseImage baseImageInsert(BaseImage image) {
        this.save(image);
        UserVO userVO = new UserVO();
        userVO.setUserNo(image.getId());
        userService.getUserInfo(userVO);
        return image;
    }

}
