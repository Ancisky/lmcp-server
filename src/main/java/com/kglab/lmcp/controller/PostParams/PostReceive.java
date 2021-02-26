package com.kglab.lmcp.controller.PostParams;

import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import com.kglab.lmcp.entity.graph.nodes.PropertyValueNode;
import com.kglab.lmcp.entity.graph.nodes.SampleNode;
import com.kglab.lmcp.entity.graph.relation.AttrIsRelation;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import com.kglab.lmcp.repository.graph.SampleRepository;
import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.controller.BaseAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.swing.*;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@RestController
@Validated
@RequestMapping(value = "/test")
public class PostReceive extends BaseAction {

    @RequestMapping(value = "/params",   produces = "application/json;charset=UTF-8")
    public String paraGet(@RequestBody JSONObject postJson) {
        System.out.println(postJson.toString());

        System.out.println(postJson.size());

        System.out.println(postJson.keySet());
        Set<String> keyset = postJson.keySet();
        String sample = postJson.getString("Sample");
        for (String key : keyset) {
            if(key == "Sample"){
                continue;
            }
            //System.out.println(Double.parseDouble(postJson.getString(key)));
            AttrValue(sample, key, Float.parseFloat(postJson.getString(key)));
        }

        return postJson.toString();

    }

    @Autowired SampleRepository sampleRepository;

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

    @Test
    public void AttrValueTest() {
        String Sample = "s-0002";
        String AttrName = "Time (s)";
        float Value = 3;
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

