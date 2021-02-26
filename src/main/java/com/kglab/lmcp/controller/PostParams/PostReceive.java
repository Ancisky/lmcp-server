package com.kglab.lmcp.controller.PostParams;

import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import com.kglab.lmcp.entity.graph.nodes.PropertyValueNode;
import com.kglab.lmcp.entity.graph.nodes.SampleNode;
import com.kglab.lmcp.entity.graph.relation.AttrIsRelation;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import com.kglab.lmcp.entity.table.Computer;
import com.kglab.lmcp.entity.table.ExceptionLog;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import com.kglab.lmcp.repository.graph.SampleRepository;
import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.repository.table.ExceptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@RestController
@Transactional(noRollbackFor = SuccessResultMessage.class)
@Validated
@RequestMapping(value = "/test")
public class PostReceive extends BaseAction {

    @Autowired ExceptionDao exceptionDao;
    @RequestMapping(value = "/params", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //接收采集端发送的数据
    public void paraGet(@RequestBody JSONObject postJson) {
        try{
            System.out.println(postJson.toString());
            System.out.println(postJson.keySet());

            Set<String> keyset = postJson.keySet();
            String sample = postJson.getString("Sample");
            for (String key : keyset) {
                if(key == "Sample"){
                    continue;
                }
                //取出数据存储数据库
                //AttrValue(sample, key, Float.parseFloat(postJson.getString(key)));
            }
            success("插入成功");
        }
        //异常记录数据库，内容包括异常数据，发生时间，异常内容
        catch (Exception e){
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println(dateFormat.format(date));
            System.out.println(e.toString());

            ExceptionLog exceLog = new ExceptionLog();
            exceLog.setData(postJson.getString("Sample"));
            exceLog.setTime(dateFormat.format(date));
            exceLog.setExce(e.toString());

            exceptionDao.save(exceLog);
        }
    }

    @Autowired SampleRepository sampleRepository;
    //存储配比数据
    public void EleProperties(String EleName, float Percent, String Code) {
        ElementNode e = ElementNode.builder().elName(EleName).build();
        HasElRelation rel = HasElRelation.builder()
                .percent(Percent)
                .targetNode(e)
                .build();
        SampleNode s = SampleNode.builder()
                .code(Code)
                .relations1(rel.toList())
                .build();
        sampleRepository.save(s);
    }
    //存储测试数值（材料属性）
    public void AttrValue(String Sample, String AttrName, float Value) {
        PropertyValueNode val = PropertyValueNode.builder()
                .propValue(Value)
                .build();
        AttrIsRelation rel = AttrIsRelation.builder()
                .attrName(AttrName)
                .targetNode(val)
                .build();
        SampleNode s = SampleNode.builder()
                .code(Sample)
                .relations2(rel.toList())
                .build();
        sampleRepository.save(s);
    }
}

