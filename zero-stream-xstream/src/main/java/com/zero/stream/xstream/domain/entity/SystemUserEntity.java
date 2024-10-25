package com.zero.stream.xstream.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserEntity {

	private String firstName;
	private String lastName;
	private int salary;
	private int age;
	private String gender;
}
