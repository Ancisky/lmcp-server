package com.kglab.lmcp.service.calculate;


import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.controller.calculate.Calculateentry;
import com.kglab.lmcp.entity.vo.DataEntity;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import com.kglab.lmcp.repository.graph.SampleRepository;
import com.kglab.lmcp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@Transactional(noRollbackFor = SuccessResultMessage.class)
public class CalculateentryService extends BaseService {

    final SampleRepository sampleRepository;
    @Autowired
    public CalculateentryService(SampleRepository sampleRepository){
        this.sampleRepository = sampleRepository;
    }

    public void calculate(@Valid Calculateentry json){
        JSONObject data = new JSONObject();
//        daodianlu = api();xxx

        data.put("导电率",2333);
        data.put("粘度",2333);
        success("录入成功！", data);
    }
}
