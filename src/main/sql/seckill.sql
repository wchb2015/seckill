-- 秒杀存储过程

DELIMITER  $$ -- console ; 转换为 $$
-- 定义存储过程
-- 参数: in　输入参数; out 输出参数
-- row_count():返回上一条修改类型的sql(delete,update,insert)的影响行数
-- row_count(): 0:未修改数据;>0 :表示修改的行数;<0:sql错误/未执行修改的sql
CREATE  PROCEDURE  `test_mysql`.`execute_seckill`
 (in v_seckill_id bigint,in v_phone bigint,in v_kill_time TIMESTAMP ,out r_result int)

BEGIN

  DECLARE insert_count int DEFAULT 0;
    START TRANSACTION ;
    INSERT ignore INTO success_killed(seckill_id,user_phone,create_time,state)VALUES(v_seckill_id,v_phone,v_kill_time,1);

    SELECT ROW_COUNT() INTO insert_count;
    IF(insert_count = 0)THEN
     ROLLBACK ;
     SET r_result=-1;
    ELSEIF(insert_count<0)THEN
     ROLLBACK ;
     SET r_result=-2;

    ELSE
     UPDATE seckill set number = number-1 WHERE seckill_id = v_seckill_id and end_time > v_kill_time and start_time <v_kill_time
     AND  number>0;
    SELECT ROW_COUNT() INTO insert_count;
     IF(insert_count<=0)THEN
      ROLLBACK ;
      SET r_result = -2;
     ELSE
      COMMIT ;
      SET r_result = 1;
     END IF;
  END IF;
END ;
$$

-- 存储过程定义

DELIMITER  ;
set @r_result=-3;
-- 执行存储过程
call execute_seckill(1004,15821112222,now(),@r_result);

-- 获取结果
SELECT  @r_result;

show create procedure execute_seckill\G

-- 存储过程
-- 存储过程优化的是事务行级锁持有的时间
-- 不要过度依赖存储过程, 简单的逻辑可以应用存储过程
-- QPS:一个秒杀单6000/qps