package com.kglab.lmcp.controller.calculate;

import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.service.calculate.CalculateentryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("calculate")

public class Calculateentry extends BaseAction {
    final CalculateentryService calculateentryService;

    protected Calculateentry(CalculateentryService c1){
        this.calculateentryService = c1;
    }

    @RequestMapping("entry")
    public void dataEntry(@Valid @RequestBody JSONObject json){
        calculateentryService.calculate(json);
    }

}
