package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.entity.graph.nodes.*;
import com.kglab.lmcp.entity.graph.relation.AllRelation;
import com.kglab.lmcp.entity.graph.relation.AttrIsRelation;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SaveGarphData {
    @Autowired
    SampleRepository sampleRepository;
    @Test
    public void EleProperties(){

        ElementNode e = ElementNode.builder().elName("Mg").build();
        HasElRelation rel = HasElRelation.builder()
                .percent(0.02f)
                .targetNode(e)
                .build();
        List<HasElRelation> relList = new ArrayList<>();
        relList.add(rel);
        SampleNode s = SampleNode.builder()
                .code("s-0001")
                .relations1(relList)
                .build();
        sampleRepository.save(s);
    }
    @Test
    public void neo4jThermalCon(){
        ElementNode e = ElementNode.builder().elName("Mg").build();
        HasElRelation rel = HasElRelation.builder()
                .percent(0.03f)
                .targetNode(e)
                .build();
        List<HasElRelation> relList = new ArrayList<>();
        relList.add(rel);
        PropertyValueNode val = PropertyValueNode.builder()
                .propValue(37.5)
                .build();
        AttrIsRelation ref2 = AttrIsRelation.builder()
                .attrName("热扩散系数")
                .targetNode(val)
                .build();
        SampleNode s = SampleNode.builder()
                .code("s-0001")
                .relations1(relList)
                .relations2(ref2.toList())
                .build();
        sampleRepository.save(s);
    }
}
