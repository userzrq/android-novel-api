package com.rockymobi.common.Exception;

import com.rockymobi.common.constant.ResultCodeEnum;
import lombok.Data;

@Data
public class RockyException extends RuntimeException{
    private Integer code;

    // Throwable类中有一个构造器包含了deleteMessage ,GuliException继承了该属性
    // 定义code 继承message

    public RockyException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public RockyException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "RockyException{" +
                "code=" + code +
                "message=" + this.getMessage() +
                '}';
    }
}
