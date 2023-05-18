package com.example.demo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sentence")
public class ScentenceSeparator {
	
	@GetMapping(value="/separate")
	EntityModel<Words> separateWords(@RequestParam(value="sentence", defaultValue=" ") String sentence){
		String[] words = sentence.split(" ");
		Words data = new Words(words);
		return EntityModel.of(data, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ScentenceSeparator.class).separateWords(sentence)).withSelfRel());
	}
}