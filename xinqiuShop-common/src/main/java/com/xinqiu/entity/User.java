package com.xinqiu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;//主键

    private String username;//用户名

    private String password;//密码

    private String telephone;//手机号

}