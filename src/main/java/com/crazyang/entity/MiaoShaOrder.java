package com.crazyang.entity;

import lombok.*;

/**
 * @ClassName MiaoShaOrder
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午11:39.
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MiaoShaOrder {

    private Integer id;

    private Integer userId;

    private Integer orderId;

    private Integer goodsId;
}
