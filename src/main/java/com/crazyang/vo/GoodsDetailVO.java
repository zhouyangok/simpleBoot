package com.crazyang.vo;

import com.crazyang.bo.GoodsBo;
import com.crazyang.entity.User;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName GoodsDetailVO
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/18 上午11:38.
 */

@Getter
@Setter
public class GoodsDetailVO {
    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private GoodsBo goods ;
    private User user;
}
