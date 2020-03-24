package com.demo.controller;

import com.demo.model.Students;
import com.demo.service.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

    private StudentsService studentsService = new StudentsService();

    @RequestMapping(value = "/allStudents", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Students> getAllStudents(){
        return studentsService.getAllStudentsList();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Students getStudent(@PathVariable int id){
        return studentsService.getStudent(id);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, headers = "Accept=application/json")
    public Students addStudent(@RequestBody Students students){
        return studentsService.addStudent(students);
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Students updateStudent(@RequestBody Students students){
        return studentsService.updateStudent(students);
    }

    @RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public List<Students> deleteStudent(@PathVariable int id){
        return studentsService.deleteStudent(id);
    }
}
