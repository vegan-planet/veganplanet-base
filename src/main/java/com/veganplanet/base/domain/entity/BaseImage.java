package com.veganplanet.base.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("base_image")
public class BaseImage implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *图片名称
     */
    private String imageName;

}
