package com.rockymobi.common.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回对象
 */
@Data
public class R {
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String meaasge;

    /**
     * 返回数据
     */
    private Map<String,Object> data = new HashMap<>();


    private R(){}

    public static R ok(){
        
    }

}
