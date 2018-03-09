package org.seckill.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Date;

@Setter
@Getter
@ToString
public class Seckill {

    private long seckillId;

    private String name;

    private int number;

    private Date startTime;

    private Date endTime;

    private Date createTime;


}
