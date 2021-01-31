package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import com.kglab.lmcp.entity.graph.nodes.SampleNode;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import org.junit.Test;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * TODO  样品节点操作数据层$
 *
 * @author sc
 * @date 2021/1/13
 */
public interface SampleRepository extends Neo4jRepository< SampleNode, String> {
}
