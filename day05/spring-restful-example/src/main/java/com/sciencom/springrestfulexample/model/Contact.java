package com.sciencom.springrestfulexample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tbl_contact")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 8403996949295099136L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "contact_city")
	private String city;
	@Column(name = "contact_phone",length = 20)
	private String phone;
	
	@OneToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "student_id",nullable = false,unique = true)
	private Student student;
}
