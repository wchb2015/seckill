package org.seckill.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

//DTO:完成WEB层到Service层的数据传递
//所有的ajax请求的返回类型封装JSON结果
@ToString
@Getter
@Setter
public class SeckillResult<T> implements Serializable {

    private static final long serialVersionUID = -3936895148526393338L;

    private boolean success;

    private T data;

    private String error;

    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

}
