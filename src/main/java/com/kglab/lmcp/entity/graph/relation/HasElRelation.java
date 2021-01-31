package com.kglab.lmcp.entity.graph.relation;


import com.kglab.lmcp.entity.graph.NodeEntity;
import com.kglab.lmcp.entity.graph.RelationShipEntity;
import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

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
    private final ElementNode targetNode;

    public List<HasElRelation> toList(){
        List<HasElRelation> list = new ArrayList<HasElRelation>();
        list.add(this);
        return list;
    }
}
