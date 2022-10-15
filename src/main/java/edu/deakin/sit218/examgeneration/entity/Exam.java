package edu.deakin.sit218.examgeneration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "questions")
public class Exam {
	
	@Id
	@Column(name = "ques")
	protected String question;
	
	@Column(name = "ans")
	protected String answer;
	
	@Column(name = "attr")
	protected String area_of_knowledge;

	public Exam(String q, String a, String k) {
		super();
		this.question = q;
		this.answer = a;
		this.area_of_knowledge = k;
	}
	
	public Exam() {
		
	}
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getArea_of_knowledge() {
		return area_of_knowledge;
	}

	public void setArea_of_knowledge(String area_of_knowledge) {
		this.area_of_knowledge = area_of_knowledge;
	}	
	
	@Override
	public String toString() {
		return "' " +getQuestion() + " ' with knowledge area: "+ getArea_of_knowledge();
	}
	
	

}
