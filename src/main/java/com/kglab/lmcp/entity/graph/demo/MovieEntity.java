package com.kglab.lmcp.entity.graph.demo;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import java.util.ArrayList;
import java.util.List;

@Node("Movie")
@Data
@Builder
public class MovieEntity {

	@Id
	private final String title;

	@Property("tagline")
	private final String description;

	@Relationship(type = "ACTED_IN", direction = Direction.INCOMING)
	private List<Roles> actorsAndRoles;

	@Relationship(type = "DIRECTED", direction = Direction.INCOMING)
	private List<PersonEntity> directors;
}