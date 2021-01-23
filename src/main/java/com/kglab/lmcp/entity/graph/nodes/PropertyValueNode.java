package com.kglab.lmcp.entity.graph.nodes;

import com.kglab.lmcp.entity.graph.NodeEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * TODO  样品性能节点$
 *
 * @author sc
 * @date 2021/1/14
 */
@Data
@Builder
@Node(labels = "PropertyValue")
public class PropertyValueNode implements NodeEntity {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private final String uuid;
    /** 属性值 **/
    private final double propValue;
}


