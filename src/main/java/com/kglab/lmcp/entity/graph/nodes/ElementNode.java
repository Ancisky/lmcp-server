package com.kglab.lmcp.entity.graph.nodes;

import com.kglab.lmcp.entity.graph.NodeEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * TODO  Mg结点$
 *
 * @author sc
 * @date 2021/1/13
 */
@Node(labels = "Element")
@Data
@Builder
public class ElementNode implements NodeEntity {

    @Id
    /** 元素名称 **/
    private final String elName;
}
