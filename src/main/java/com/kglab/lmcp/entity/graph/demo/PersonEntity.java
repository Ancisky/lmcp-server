package com.kglab.lmcp.entity.graph.demo;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

@Node("Person")
@Data
@Builder
public class PersonEntity {

	@Id private final String name;

	private final Integer born;

}