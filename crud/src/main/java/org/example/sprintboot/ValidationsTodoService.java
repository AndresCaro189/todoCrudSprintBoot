package org.example.sprintboot;

import java.util.Date;
import java.util.Optional;

public class ValidationsTodoService extends TodoService {
    static void defaultValues(Todo todo) {
        var groupListId = Optional.ofNullable(todo.getGroupListId()).orElse(DEFAULT);
        todo.setGroupListId(groupListId);
        var date = Optional.ofNullable(todo.getDate()).orElse(new Date());
        todo.setDate(date);
    }

    static void validLengAllow(String name) {
        if(name.length()<3 || name.length()>100){
            throw new IllegalArgumentException("Se permiten caracteres de 3 hasta 100");
        }
    }
}
