package com.InstituteManagementSystemUI.IMSui.Controller;


import com.InstituteManagementSystemUI.IMSui.Model.Student;
import com.InstituteManagementSystemUI.IMSui.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The MainController class is a REST controller for managing student data in the Institute Management System.
 */
@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Retrieve a list of all students
     * @return a list of all students
     */
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudent();
    }

    /**
     * Retrieve a specific student by ID
     * @param id the ID of the student to retrieve
     * @return the student with the specified ID
     */
    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable(name="id") int id){
        return studentService.getStudent(id);
    }

    /**
     * Create a new student
     * @param currStudent the student to create
     * @return the newly created student
     */
    @PostMapping
    public Student createStudent(@RequestBody Student currStudent){
        studentService.createStudent(currStudent);
        return currStudent;
    }

    /**
     * Update an existing student
     * @param id the ID of the student to update
     * @param currStudent the updated student data
     * @return the updated student
     */
    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable(name="id") int id, @RequestBody Student currStudent){
        studentService.updateStudent(id, currStudent);
        return currStudent;
    }

    /**
     * Delete a student
     * @param id the ID of the student to delete
     * @return the deleted student
     */
    @DeleteMapping(path = "/{id}")
    public Student deleteStudent(@PathVariable(name="id") int id) {
        return studentService.deleatStudent(id);
    }
}
