package com.crazyang.core.exception;

import com.crazyang.result.CodeMsg;

import java.io.Serializable;

/**
 * @ClassName GlobalException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/22 下午5:23.
 */

public class GlobalException extends RuntimeException implements Serializable {

    private String msg;
    private Integer code;

    public GlobalException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public GlobalException(CodeMsg codeMsg){
        super(codeMsg.getMsg());
        this.code = codeMsg.getCode();
    }

    public GlobalException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public GlobalException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public GlobalException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
