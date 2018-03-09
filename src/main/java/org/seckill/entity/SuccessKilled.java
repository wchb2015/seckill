package org.seckill.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SuccessKilled {

    /**
     * 一个秒杀seckill对应多个成功记录
     */
    private Seckill seckill;

    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

}
