package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/calculator")
public class calculator {
	
	@GetMapping(value="/add")
	public EntityModel<Result> add(@RequestParam(value="x", defaultValue="0") double x, @RequestParam(value="y", defaultValue="0") double y) {
		double result = x + y;
		Result finalResult = new Result(x, y, result, 1);
		List<Link> links = new ArrayList<>();
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).add(x, y)).withSelfRel());
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).sub(x, y)).withRel("sub"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).mul(x, y)).withRel("mul"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).div(x, y)).withRel("div"));
		return EntityModel.of(finalResult, links);
	}
	
	@GetMapping(value="/sub")
	public EntityModel<Result> sub(@RequestParam(value="x", defaultValue="0") double x, @RequestParam(value="y", defaultValue="0") double y) {
		double result = x - y;
		Result finalResult = new Result(x, y, result, 2);
		List<Link> links = new ArrayList<>();
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).sub(x, y)).withSelfRel());
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).add(x, y)).withRel("add"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).mul(x, y)).withRel("mul"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).div(x, y)).withRel("div"));
		return EntityModel.of(finalResult, links);
	}
	
	@GetMapping(value="/mul")
	public EntityModel<Result> mul(@RequestParam(value="x", defaultValue="0") double x, @RequestParam(value="y", defaultValue="0") double y) {
		double result = x * y;
		Result finalResult = new Result(x, y, result, 3);
		List<Link> links = new ArrayList<>();
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).mul(x, y)).withSelfRel());
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).add(x, y)).withRel("add"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).sub(x, y)).withRel("sub"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).div(x, y)).withRel("div"));
		return EntityModel.of(finalResult, links);
	}
	
	@GetMapping(value="/div")
	public EntityModel<Result> div(@RequestParam(value="x", defaultValue="0") double x, @RequestParam(value="y", defaultValue="0") double y) {
		double result = x / y;
		Result finalResult = new Result(x, y, result, 4);
		List<Link> links = new ArrayList<>();
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).div(x, y)).withSelfRel());
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).add(x, y)).withRel("add"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).sub(x, y)).withRel("sub"));
		links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(calculator.class).mul(x, y)).withRel("mul"));
		return EntityModel.of(finalResult, links);
	}
}
