package com.sciencom.springrestfulexample.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "tbl_student")
public class Student implements Serializable {

	private static final long serialVersionUID = 3531785315185816511L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "student_name",nullable = false,length = 100)
	private String name;
	
	@Column(name = "student_age",nullable = false)
	private int age;
	
	@OneToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL, mappedBy = "student" )
	private Contact contact;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "student")
	private List<Assignment> assignments;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_student_subject",
	joinColumns = @JoinColumn(name="student_id",referencedColumnName = "id"),
	inverseJoinColumns =@JoinColumn(name="subject_id",referencedColumnName = "id"))
	private List<Subject> subjects;
	
}
