package com.example.demo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class RecordsModelAssembler implements RepresentationModelAssembler<Records, EntityModel<Records>>{

	@Override
	public EntityModel<Records> toModel(Records entity) {
		return EntityModel.of(
				entity, 
				WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
						.getRecord(entity.getId()))
				.withSelfRel(),
				WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
						.getAllRecords())
				.withRel("records")
				);
	}

}
