package com.CC_Assignment.secondQue;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/posts")

public class PostController {
private final PostModelAssembler assembler;
	
	public PostController(PostModelAssembler assembler) {
		this.assembler = assembler;
	}
	
	@GetMapping(value="/all")
	public CollectionModel<EntityModel<Post>> getPosts(){
		
	}
}
