package com.kglab.lmcp.entity.graph.demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@RelationshipProperties
@Data
@Builder
public class Roles {

	private final List<String> roles;

	@TargetNode
	private final PersonEntity person;

}