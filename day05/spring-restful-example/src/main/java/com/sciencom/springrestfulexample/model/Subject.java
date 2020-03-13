package com.sciencom.springrestfulexample.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_subject")
public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1979154100824821575L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "assignment_name",length = 100)
	private String name;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;
}
