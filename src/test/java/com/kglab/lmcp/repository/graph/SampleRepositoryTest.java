package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import com.kglab.lmcp.entity.graph.nodes.SampleNode;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO  $
 *
 * @author sc
 * @date 2021/1/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SampleRepositoryTest{

    @Autowired SampleRepository sampleRepository;

    @Test
    public void test1(){
        ElementNode e = ElementNode.builder().elName("Mg").build();
        HasElRelation rel = HasElRelation.builder()
                .percent(0.02f)
                .targetNode(e)
                .build();
        List<HasElRelation> list = new ArrayList<>();
        list.add(rel);
        SampleNode s = SampleNode.builder()
                .code("s2020-001")
                .relations1(list)
                .build();
        sampleRepository.save(s);
    }
}