package org.seckill.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 暴露秒杀地址DTO(dto:web层和service层传递数据用)
 * Created by wchb7 on 16-5-13.
 */

@Getter
@Setter
@ToString
public class Exposer implements Serializable {

    private static final long serialVersionUID = 7602244494037452541L;

    /**
     * 秒杀是否开启
     */
    private boolean exposed;

    private String md5;

    private long seckillId;

    /**
     * 系统时间(毫秒)
     */
    private long now;

    private long start;

    private long end;

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }


}
