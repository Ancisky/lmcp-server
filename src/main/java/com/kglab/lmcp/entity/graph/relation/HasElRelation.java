package com.kglab.lmcp.entity.graph.relation;


import com.kglab.lmcp.entity.graph.NodeEntity;
import com.kglab.lmcp.entity.graph.RelationShipEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

/**
 * TODO  关系：<样品>包含<元素>$
 *
 * @author sc
 * @date 2021/1/13
 */
@Data
@Builder
@RelationshipProperties()
public class HasElRelation implements RelationShipEntity {

    @Property(name = "percent")
    private final float percent;

    @TargetNode
    private final NodeEntity targetNode;
}
