package com.java.sjzl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huoqiang
 * @description
 * @date 2021/6/23
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable{

    private static final long serialVersionUID = 5511011316958393821L;

    /**
     * 主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别。0：未知；1：男；2：女
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 固定电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 出生日期
     */
    private Date birthday;
}
