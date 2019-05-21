package com.crazyang.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OperationLog
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/21 下午3:33.
 */

@Entity
@Data
@Table(name = "operation_log")
public class OperationLog implements Serializable {

    private static final long serialVersionUID = -7252854363243430423L;
    @Id
    private int id;
    private int userId;
    private String userIp;
    private String userAction;
    private Date createTime;

}
