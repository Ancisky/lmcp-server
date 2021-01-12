package com.kglab.lmcp.service.UserLogin;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.entity.po.User;
import com.kglab.lmcp.global.handle.exception.result.ResultVoMessage;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import com.kglab.lmcp.repository.UserDao;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserLoginService {

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
           throw new ResultVoMessage(StatusCode.FAIL,"用户不存在！");
       }else if(u.getPassword().equalsIgnoreCase(password)){
           throw new ResultVoMessage(StatusCode.SUCCESS,"登陆成功！");
       }else{
           throw new ResultVoMessage(StatusCode.FAIL,"密码错误！");
       }
   }
}
