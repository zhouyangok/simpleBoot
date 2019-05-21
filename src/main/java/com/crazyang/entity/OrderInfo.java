package com.crazyang.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderInfo
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/21 下午2:09.
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private Long id;

    private Long userId;

    private Long goodsId;

    private Long addrId;

    private String goodsName;

    private Integer goodsCount;

    private BigDecimal goodsPrice;

    private Integer orderChannel;

    private Integer status;

    private Date createDate;

    private Date payDate;

}
