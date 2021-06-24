package com.java.sjzl.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author huoqiang
 * @description 导入VO类
 * @date 2021/6/23
 */
@Data
public class UserImportVO implements Serializable,IExcelModel, IExcelDataModel {

    @NotBlank
    @Excel(name = "姓名")
    private String realName;

    @Excel(name = "性别", replace = { "男_1", "女_2" })
    private Integer sex;

    @Excel(name = "出生日期", format = "yyyy-MM-dd")
    private Date birthday;

    @Length(min=1, max=11, message = "请填写正确的手机号")
    @Excel(name = "手机号码")
    private String phone;

    @Excel(name = "固定电话")
    private String tel;

    @Email(message = "请填写正确的邮箱地址")
    @Excel(name = "邮箱")
    private String email;

    @Excel(name = "头像地址")
    private String avatar;

    @Excel(name = "信息")
    private String errorMsg;

    private Integer rowNum;

    @Override
    public Integer getRowNum() {
        return this.rowNum;
    }

    @Override
    public void setRowNum(Integer i) {
        this.rowNum = i;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public void setErrorMsg(String s) {
        this.errorMsg = s;
    }
}
