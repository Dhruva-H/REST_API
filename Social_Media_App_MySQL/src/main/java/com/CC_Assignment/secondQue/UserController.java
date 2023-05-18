package com.CC_Assignment.secondQue;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	private final UserModelAssembler assembler;
	
	public UserController(UserModelAssembler assembler, UserRepository repository) {
		this.assembler = assembler;
		this.repository = repository;
	}
	@GetMapping(value="/all")
	public CollectionModel<EntityModel<User>> getAllUsers() {
		Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withSelfRel();
		List<EntityModel<User>> users = repository.findAll().stream().map(user -> assembler.toModel(user)).collect(Collectors.toList());
		return CollectionModel.of(users, selfLink);
	}
	
	@GetMapping(value="/{id}")
	public EntityModel<User> getUser(@PathVariable("id") long id){
		User user = repository.findById(id);
		return assembler.toModel(user);
	}
	
	@PostMapping(value="/create")
	public EntityModel<User> createUser(@RequestBody User data){
		//logic to add user to DB
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		//logic to delete user from DB
	}
	
	@PutMapping(value="/change/{id}")
	public EntityModel<User> changeUserDetails(@PathVariable("id") long id, @RequestBody User data) {
		//logic to change user details
	}
}