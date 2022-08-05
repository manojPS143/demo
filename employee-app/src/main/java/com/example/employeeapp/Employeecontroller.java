package com.example.employeeapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employeecontroller {
@Autowired
EmployeeReposatory ER;

@PostMapping("/saveEmployee")
public Employee saveEmployee(@RequestBody Employee E) {
	Employee E1=ER.save(E);
	return E1;
}
@GetMapping("/getEmplyoee")
public List<Employee> getEmplyoee(){
	return ER.findAll();
}
@PostMapping("/updateEmployee")
public Employee updateEmployee(@RequestParam int id,@RequestBody Employee E) {
	Optional<Employee> O=ER.findById(id);
	if(O.isEmpty()) {
		return null;
	}else {
		return ER.save(E);
	}
}
@DeleteMapping("/deleteEmployee")
public String DeleteEmployeeById(@RequestParam int id) {
	Optional<Employee>O=ER.findById(id);
	if(O.isEmpty()) {
		return "no delete";
	}else {
		Employee E=O.get();
		ER.delete(E);
		return "data deleted";
	}
}
}
