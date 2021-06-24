package com.java.sjzl.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.sjzl.entity.User;
import com.java.sjzl.handler.UserVerifyHandler;
import com.java.sjzl.mapper.UserMapper;
import com.java.sjzl.service.IUserService;
import com.java.sjzl.vo.UserExportVO;
import com.java.sjzl.vo.UserImportVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huoqiang
 * @description
 * @date 2021/6/23
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserVerifyHandler userVerifyHandler;

    @Override
    public String importExcel(MultipartFile file) throws Exception{
        ImportParams importParams = new ImportParams();
        //表格标题行数,默认0
        importParams.setTitleRows(1);
        //是否需要校验上传的Excel
        importParams.setNeedVerify(true);
        //告诉easypoi我们自定义的验证器
        importParams.setVerifyHandler(userVerifyHandler);
        ExcelImportResult<UserImportVO> result = ExcelImportUtil.importExcelMore(file.getInputStream(),UserImportVO.class,importParams);
        if (!result.isVerifyFail() && !CollectionUtils.isEmpty(result.getList())) {
            for (UserImportVO vo : result.getList()) {
                log.info("从Excel导入数据到数据库的详细为 ：{}", vo);
                User user = new User();
                BeanUtil.copyProperties(vo,user);
                this.save(user);
            }
        } else {
            for (UserImportVO vo : result.getFailList()) {
                log.info("校验失败的详细为 ：{}", vo);
            }
            return "文档校验失败";
        }
        return "导入成功";
    }

    @Override
    public List<UserExportVO> getUserExportList() {
        List<User> users = this.list();
        //users集合转成export集合
        List<UserExportVO> exportVOList = users.stream().map(user -> {
            UserExportVO vo = new UserExportVO();
            BeanUtils.copyProperties(user, vo);
            return vo;
        }).collect(Collectors.toList());
        return exportVOList;
    }
}
