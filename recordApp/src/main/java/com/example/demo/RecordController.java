package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/registry")
public class RecordController {
	private final RecordsModelAssembler assembler;
	private static final String templet = "Hello, %s!";
	private List<Records> records = new ArrayList<>();
	
	public List<Records> getrecords(){
		return this.records;
	}
	
	private void initializeRecords() {
		Records r1 = new Records(1, "Dhruva", "Teja", "Hyderabad");
		Records r2 = new Records(2, "Chaitanya", "Kumar", "Hyderabad");
		Records r3 = new Records(3, "Anusri", "S", "Hyderabad");
		Records r4 = new Records(4, "Bhuvan", "Verma", "Hyderabad");
		this.records.add(r1);
		this.records.add(r2);
		this.records.add(r3);
		this.records.add(r4);
	}
	
	public RecordController(RecordsModelAssembler assembler) {
		this.assembler = assembler;
		this.initializeRecords();
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "arg", defaultValue = "user") String arg ) {
		return String.format(templet, arg);
	}
	
	@GetMapping("/records")
	public CollectionModel<EntityModel<Records>> getAllRecords(){
		Link selfLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
				.getAllRecords())
				.withSelfRel();
		List<EntityModel<Records>> responseData;
		/*
		responseData = records
				.stream().map(record -> EntityModel.of(
						record, 
						WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
								.getRecord(record.getId()))
						.withSelfRel(),
						WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
								.getAllRecords())
						.withRel("records"))
				).collect(Collectors.toList());
		*/
		responseData = records.stream().map(record -> assembler.toModel(record)).collect(Collectors.toList());
		return CollectionModel.of(responseData, selfLink);
	}
	
	@GetMapping("records/{id}")
	public EntityModel<Records> getRecord(@PathVariable("id") int id) {
		Records reqRecord = null;
		int flag = 0;
		ListIterator<Records> iterator = records.listIterator();
		while(iterator.hasNext()) {
			reqRecord = iterator.next();
			int ID = reqRecord.getId();
			if(ID == id) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			/*
			List<Link> linkList = new ArrayList<>();
			linkList.add(
					WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
							.getRecord(id))
					.withSelfRel());
			linkList.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(RecordController.class)
							.getAllRecords())
					.withRel("Records"));
			return EntityModel.of(reqRecord, (Iterable<Link>)linkList);
			*/
			return assembler.toModel(reqRecord);
		}
		return null;
	}
	
	@PostMapping("records/add")
	public List<Records> addRecord(@RequestBody Records data){
		records.add(data);
		return records;
	}
}