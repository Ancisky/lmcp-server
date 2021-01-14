package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * TODO  ElementNode Repository$
 *
 * @author sc
 * @date 2021/1/13
 */
public interface ElementRepository extends Neo4jRepository<ElementNode, String> {

}
