package org.seckill.exception;

/**
 * 秒杀相关业务异常
 * Created by wchb7 on 16-5-14.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }

}
