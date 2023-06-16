package com.xinqiu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_product")
public class Product {

    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;//主键
    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存

}
