package com.kglab.lmcp.entity.graph.nodes;

import com.kglab.lmcp.entity.graph.NodeEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * TODO  样品性能节点$
 *
 * @author sc
 * @date 2021/1/14
 */
@Data
@Builder
@Node(labels = "property")
public class PropertyNode implements NodeEntity {
    @Id
    /** 元素名称 **/
    private final String propName;
}


