package com.java.sjzl.controller;

import com.java.sjzl.entity.User;
import com.java.sjzl.service.IUserService;
import com.java.sjzl.util.ExcelUtil;
import com.java.sjzl.vo.UserExportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author huoqiang
 * @description
 * @date 2021/6/23
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/importExcel")
    public String importExcel(@RequestParam("file") MultipartFile file) {
        try {
            String result = userService.importExcel(file);
            return result;
        } catch (Exception e) {
            return "导入失败";
        }
    }

    @GetMapping("/exportExcel")
    public void export(HttpServletResponse response) {
        //查询要导出的数据
        List<UserExportVO> users = userService.getUserExportList();
        ExcelUtil.exportExcelX(users, "测试导出表", "sheet1", UserExportVO.class, "测试导出表.xlsx", response);
    }
}
