package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return　如果更新行数大于1,表示更新的行数
     */
    Integer reduceNumber(@Param("seckillId") Long seckillId, @Param("killTime") Date killTime);


    /**
     * 根据ID查询秒杀对象
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(Long seckillId);


    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);

}
