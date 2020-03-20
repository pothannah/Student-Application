package com.interopx.platform.datametrics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interopx.platform.datametrics.exceptions.RecordNotFoundException;
import com.interopx.platform.datametrics.model.StudentEntity;
import com.interopx.platform.datametrics.service.StudentService;
 
@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentService service;
 
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> list = service.getAllStudents();
        return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        StudentEntity entity = service.getStudentById(id);
 
        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(StudentEntity Student)
                                                    throws RecordNotFoundException {
        StudentEntity updated = service.createOrUpdateStudent(Student);
        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
}