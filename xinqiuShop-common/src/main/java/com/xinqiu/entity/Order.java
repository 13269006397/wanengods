package com.xinqiu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_order")
public class Order {

    private int oid;//订单id
    //用户
    private Integer uid;//用户id
    private String uname;//用户名
    //商品
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价
    //数量
    private Integer pnumber;//购买数量
}