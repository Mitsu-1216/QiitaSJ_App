package model;

import java.util.List;

public class RegisterLogic {
	public void execute(TodoBeans todo, List<TodoBeans> todoList) {
		todoList.add(0, todo);
	}
}
