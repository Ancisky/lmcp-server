package com.kglab.lmcp.service.UserLogin;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.entity.table.User;
import com.kglab.lmcp.global.handle.exception.result.ResultVoMessage;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import com.kglab.lmcp.repository.table.UserDao;
import com.kglab.lmcp.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO 用户登陆服务接口
 * @author sc
 * @date 2021/1/14
 */
@Service
@Transactional(noRollbackFor = SuccessResultMessage.class)

public class UserLoginService extends BaseService {

    final UserDao userDao;

    /**
     * TODO 使用构造器注入依赖bean！！
     * @author sc
     * @date 2021/1/12
     */
    public UserLoginService(UserDao userDao){
        this.userDao = userDao;
    }


   public void validateLoginForm (String username, String password){
       User u = userDao.findByUsername(username);
       if(u==null){
           fail("用户不存在");
       }else if(u.getPassword().equalsIgnoreCase(password)){
           success("登陆成功！");
       }else{
           fail("密码错误！");
       }
   }
}
