package org.example.sprintboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService service;

	@GetMapping(value = "api/todos")
	public Iterable<Todo> listGroupId(@RequestParam(name = "groupId", defaultValue = TodoService.DEFAULT) String groupId){
		return service.list(groupId);
	}


	@PostMapping(value = "api/todo")
	public Todo save(@RequestBody Todo todo){
	    return service.create(todo);
	}
	

	@PutMapping(value = "api/todo")
	public Todo update(@RequestBody Todo todo){
	    return service.update(todo);
	}
	

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
	    service.delete(id);
	}
	

	@GetMapping(value = "api/{id}/todo")
	public Todo get(@PathVariable("id") Long id){
	    return service.get(id);
	}
}
