package com.crazyang.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Goods
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午4:49.
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Date createDate;

    private Date updateDate;

    private String goodsDetail;
}
