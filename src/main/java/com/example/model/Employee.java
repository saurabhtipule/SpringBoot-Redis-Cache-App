package com.example.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{

	private int empId;

	private String empName;

	private double salary;

}
