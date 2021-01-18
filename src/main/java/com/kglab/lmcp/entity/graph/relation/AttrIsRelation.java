package com.kglab.lmcp.entity.graph.relation;


import com.kglab.lmcp.entity.graph.NodeEntity;
import com.kglab.lmcp.entity.graph.RelationShipEntity;
import com.kglab.lmcp.entity.graph.nodes.PropertyValueNode;
import com.kglab.lmcp.entity.graph.nodes.ValueNode;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO  关系：<样品>热导率是<值>$
 *
 * @author sc
 * @date 2021/1/13
 */
@Data
@Builder
@RelationshipProperties()
public class AttrIsRelation implements RelationShipEntity {

    //@Property(name = "ThermalCon")
    //private final float percent;
    @Property
    private final String attrName;

    @TargetNode
    private final PropertyValueNode targetNode;

    public List<AttrIsRelation> toList(){
        List<AttrIsRelation> list = new ArrayList<AttrIsRelation>();
        list.add(this);
        return list;
    }
}