package com.kglab.lmcp.entity.graph.nodes;

import com.kglab.lmcp.entity.graph.NodeEntity;
import com.kglab.lmcp.entity.graph.RelationShipEntity;
import com.kglab.lmcp.entity.graph.relation.AllRelation;
import com.kglab.lmcp.entity.graph.relation.AttrIsRelation;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

/**
 * TODO  样品节点，用于标识制备样品(编号)$
 *
 * @author sc
 * @date 2021/1/13
 */
@Node(labels = "Sample")
@Data
@Builder
public class SampleNode implements NodeEntity {


    @Id
    /** 样品的编号 **/
    private final String code;

    /** 带属性关系集合 **/
    @Relationship(type = "HasEle", direction = Relationship.Direction.OUTGOING)
    private List<HasElRelation> relations1;
    @Relationship(type = "AttrIs", direction = Relationship.Direction.OUTGOING)
    private List<AttrIsRelation> relations2;


}
