package com.java.sjzl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.sjzl.entity.User;
import com.java.sjzl.vo.UserExportVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author huoqiang
 * @description
 * @date 2021/6/23
 */
public interface IUserService extends IService<User>{

    String importExcel( MultipartFile file) throws Exception;

    List<UserExportVO> getUserExportList();
}
