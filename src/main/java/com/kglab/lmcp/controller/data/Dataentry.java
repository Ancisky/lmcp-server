package com.kglab.lmcp.controller.data;

import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.service.UserLogin.UserLoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@RequestMapping("data")
public class Dataentry extends BaseAction {


    @RequestMapping("entry")
    public void dataEntry(Map<String,String> form,String id) {
        rebut("ok",id);
    }
}
