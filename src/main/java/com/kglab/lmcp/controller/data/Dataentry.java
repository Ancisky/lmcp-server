package com.kglab.lmcp.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.entity.vo.DataEntity;
import com.kglab.lmcp.service.UserLogin.UserLoginService;
import com.kglab.lmcp.service.data.DataentryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@RequestMapping("data")

public class Dataentry extends BaseAction {

    final DataentryService dataentryService;

    protected Dataentry(DataentryService s1){
        this.dataentryService = s1;
    }


    @RequestMapping("entry")
    public void dataEntry(@Valid @RequestBody DataEntity json){
        dataentryService.SaveOneSample(json);
    }
}
