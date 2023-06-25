package model;

import java.io.Serializable;

public class TodoBeans implements Serializable {
	private String text;
	private String deadline;

	public TodoBeans() {
	}

	public TodoBeans (String text,String deadline) {
		this.text = text;
		this.deadline = deadline;
	}

	public String getText() {
		return text;
	}
	
	public String getDeadline() {
		return deadline;
	}
}