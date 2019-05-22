package com.crazyang.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    private String goodsName;
    @NotBlank
    private String goodsTitle;

    private String goodsImg;

    @NotNull
    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Date createDate;

    private Date updateDate;

    private String goodsDetail;
}
