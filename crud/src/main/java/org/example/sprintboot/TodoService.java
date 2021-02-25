package org.example.sprintboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Objects;

@Service
public class TodoService {

	public static final String DEFAULT = "main";

	@Autowired
	private TodoRepository repository;
	
	public Iterable<Todo> list(String groupId){
		return repository.findAllByGroupListId(groupId);
	}

	public Todo update(Todo todo){
		validadOf(todo);
		validId(todo.getId());
		return repository.save(todo);
	}

	private void validId(Long id) {
		if (Objects.isNull(id)){
		 throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El identificador no esta presente");
		}
	}

	public Todo create(Todo todo){
		validadOf(todo);
		return repository.save(todo);
	}

	private void validadOf(Todo todo) {
		try {
			Objects.requireNonNull(todo,"El nombre que esta tratando guardar es nulo :'(");
			var name = Objects.requireNonNull(todo.getName(),"El nombre no puede ser nulo");
			ValidationsTodoService.validLengAllow(name);
			ValidationsTodoService.defaultValues(todo);
		}catch (RuntimeException exception){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
		}
	}


	public void delete(Long id){
		validId(id);
		repository.delete(get(id));
	 }

	public Todo get(Long id){
	     return repository.findById(id).orElseThrow();
	 }
}
