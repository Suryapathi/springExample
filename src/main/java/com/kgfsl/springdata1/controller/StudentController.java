package com.kgfsl.springdata1.controller;

//
import java.util.List;

import com.kgfsl.springdata1.model.Student;
import com.kgfsl.springdata1.repository.*;

//import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
  @Autowired
  private StudentRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Student> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Student findone(@PathVariable Long id) {
    return  repo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Student addItem(@RequestBody Student student) {
	  student.setId(null);
    return repo.saveAndFlush(student);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Student updateemployee(@RequestBody Student updatedemployee, @PathVariable Integer id) {
    updatedemployee.setId(id);
    return repo.saveAndFlush(updatedemployee);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Long id) {
    repo.delete(id);
  }
}






/**
 * StudentController

 */

/*
@Controller
public class StudentController{
    @Autowired
    StudentRepository studentRepository;

	@RequestMapping("/")
	public ModelAndView hello () throws Exception {
		List<Student> listUsers = studentRepository.findAll();
		ModelAndView model = new ModelAndView("Userlist");
		model.addObject("userList", listUsers);
		return model;
	}
	*/
	
	// @RequestMapping(value = "/new", method = RequestMethod.GET)
	// public ModelAndView newStudent() {
	// 	ModelAndView model = new ModelAndView("UserForm");
	// 	model.addObject("user", new Student());
	// 	return model;		
	// }

