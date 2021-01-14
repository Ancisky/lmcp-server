package com.kglab.lmcp.repository.graph.demo;

import com.kglab.lmcp.entity.graph.demo.MovieEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * TODO  ElementNode Repository$
 *
 * @author sc
 * @date 2021/1/13
 */
public interface DemoRepository extends Neo4jRepository<MovieEntity, String> {

}
