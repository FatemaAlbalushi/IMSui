package com.InstituteManagementSystemUI.IMSui.Service;


import com.InstituteManagementSystemUI.IMSui.Model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The StudentService class provides services for managing student data in the Institute Management System.
 */
@Service
public class StudentService {

    /**
     * Retrieve a list of all students.
     * @return a list of all students
     */
    public List<Student> listofStudent = new CopyOnWriteArrayList<>();
    int currId = 1;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    /**
     * Retrieve a list of all students.
     * @return a list of all students
     */
    public List<Student>getAllStudent(){
        logger.info("Getting all student");
        return listofStudent;
    }

    /**
     * Retrieve a specific student by ID.
     * @param id the ID of the student to retrieve
     * @return the student with the specified ID
     */
    public Student getStudent(int id) {
        Optional<Student> foundRecode =  listofStudent.stream().filter(
                (currentStudent) -> {
                    return currentStudent.Stusentid == id;
                }
        ).findFirst();

        logger.info("get student with id: " + id);
        return foundRecode.orElse(null);

    }

    /**
     * Create a new student.
     * @param currStudent the student to create
     * @return the newly created student
     */
    public Student createStudent(Student currStudent){
        currStudent.Stusentid=this.currId ++;
        listofStudent.add(currStudent);

        logger.info("Created student with id: " + currStudent.Stusentid);
        return currStudent;
    }

    /**
     * Update an existing student.
     * @param id the ID of the student to update
     * @param updatedStudent the updated student data
     * @return the updated student
     */
    public Student updateStudent(int id,Student updatedStudent){
        Student foundStudent = getStudent(id);
        foundStudent.Studentname = updatedStudent.Studentname;
        foundStudent.Studentemail= updatedStudent.Studentemail;
        logger.info("updated student with id: " + id);
        return foundStudent;
    }

    /**
     * Delete a student.
     * @param id the ID of the student to delete
     * @return the deleted student
     */
    public Student deleatStudent(int id){
        Student foundStudent = getStudent(id);
        listofStudent.remove(foundStudent);
        logger.info("delete student with id: " + id);

        return foundStudent;
    }
}

