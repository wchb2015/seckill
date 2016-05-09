###慕课网Java高并发秒杀 ([课程](http://www.imooc.com/learn/587))

####SQL脚本
```sql
CREATE TABLE seckill(
`seckill_id` BIGINT NOT NUll AUTO_INCREMENT COMMENT '商品库存ID',
`name` VARCHAR(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`start_time` TIMESTAMP  NOT NULL COMMENT '秒杀开始时间',
`end_time` TIMESTAMP  NOT NULL COMMENT '秒杀结束时间',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'

-- 初始化数据
INSERT into seckill(name,number,start_time,end_time)
VALUES
('1000元秒杀iphone6',100,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
('800元秒杀ipad',200,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
('6600元秒杀mac book pro',300,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
('7000元秒杀iMac',400,'2016-01-01 00:00:00','2016-01-02 00:00:00')

-- 秒杀成功明细表
-- 用户登录认证相关信息(简化为手机号)
CREATE TABLE success_killed(
`seckill_id` BIGINT NOT NULL COMMENT '秒杀商品ID',
`user_phone` BIGINT NOT NULL COMMENT '用户手机号',
`state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
`create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
KEY idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表'

SHOW CREATE TABLE seckill\G;#显示表的创建信息
```

1. Mybatis两个问题?①sql写在哪里?②怎么实现DAO接口?第一个问题:注解或者XML选择XML.第二个问题:Mapper自动实现DAO接口或者API编程方式实现DAO接口.选择Mapper.
