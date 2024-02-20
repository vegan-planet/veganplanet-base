package com.veganplanet.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.veganplanet.base.domain.entity.BaseImage;
import com.veganplanet.user.api.dto.UserDTO;
import com.veganplanet.user.api.vo.UserVO;

public interface BaseService extends IService<BaseImage> {

    UserDTO getBaseInfo(UserVO userVO);

    BaseImage baseImageInsert(BaseImage image);
}
