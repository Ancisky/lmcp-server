package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.entity.graph.demo.MovieEntity;
import com.kglab.lmcp.entity.graph.demo.PersonEntity;
import com.kglab.lmcp.entity.graph.demo.Roles;
import com.kglab.lmcp.repository.graph.demo.DemoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO  $
 *
 * @author sc
 * @date 2021/1/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoNeo4jRepositoryTest {
//    @Autowired SampleRepository sampleRepository;
    @Autowired DemoRepository demoRepository;

    @org.junit.Test
    public void test(){
       PersonEntity  stu_son = PersonEntity.builder().name("小明").born(26).build();
       PersonEntity  te_fa = PersonEntity.builder().name("小明爸爸").born(26).build();
        MovieEntity m = MovieEntity.builder()
                .title("《电影超人》")
                .description("舒超演的电影")
                .actorsAndRoles(new LinkedList<>(){{
                        push(Roles.builder().roles( new LinkedList<>(){{push("学生");push("儿子");}}).person(stu_son).build());
                        push(Roles.builder().roles( new LinkedList<>(){{push("教师");push("爸爸");}}).person(te_fa).build());
                }})
                .directors(new LinkedList<>(){{
                    push(PersonEntity.builder().name("导演1").born(26).build());
                    push(PersonEntity.builder().name("导演2").born(27).build());
                }}).build();
        m = demoRepository.save(m);
    }
    @org.junit.Test
    public void test2(){
      List<MovieEntity> l =  demoRepository.findAll();
        System.out.println("测试");
    }
}