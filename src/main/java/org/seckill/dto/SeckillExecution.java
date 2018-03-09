package org.seckill.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

import java.io.Serializable;

/**
 * 封装秒杀执行后的结果
 * Created by wchb7 on 16-5-13.
 */
@Getter
@Setter
@ToString
public class SeckillExecution implements Serializable {

    private static final long serialVersionUID = 2160123709223365015L;

    private long seckillId;

    /**
     * 秒杀执行结果状态
     */
    private int state;

    /**
     * 状态表示
     */
    private String stateInfo;

    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, String stateInfo) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.stateInfo = stateInfo;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

}
