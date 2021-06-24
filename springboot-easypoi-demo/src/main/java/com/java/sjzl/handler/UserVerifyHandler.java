package com.java.sjzl.handler;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.java.sjzl.entity.User;
import com.java.sjzl.service.IUserService;
import com.java.sjzl.vo.UserImportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huoqiang
 * @description 自定义规则校验
 * @date 2021/6/24
 */
@Component
public class UserVerifyHandler implements IExcelVerifyHandler<UserImportVO> {

    @Autowired
    private IUserService userService;

    @Override
    public ExcelVerifyHandlerResult verifyHandler(UserImportVO vo) {
        ExcelVerifyHandlerResult result = new ExcelVerifyHandlerResult();
        //假设我们要添加用户，现在去数据库查询realName，如果存在则表示校验不通过。
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getRealName,vo.getRealName()));
        if (user!=null) {
            result.setMsg("唯一校验失败");
            result.setSuccess(false);
            return result;
        }
        result.setSuccess(true);
        return result;
    }
}
