package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.SpringTest;
import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import com.kglab.lmcp.entity.graph.nodes.SampleNode;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        ElementNode e = ElementNode.builder().elName("Cu").build();
        HasElRelation rel = HasElRelation.builder()
                .percent(0.02f)
                .targetNode(e)
                .build();
        SampleNode s = SampleNode.builder()
                .code("s2020-001")
                .relation(rel)
                .build();
        sampleRepository.save(s);
    }
}