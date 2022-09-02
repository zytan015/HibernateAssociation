package org.dxc.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String qname;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	@OrderColumn(name="type")
	private List<Answer> answer;

	public int getId() {
		return id;
	}

	public String getQname() {
		return qname;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
}
