package com.interopx.platform.datametrics.service;

import java.util.List;

import com.interopx.platform.datametrics.exceptions.RecordNotFoundException;
import com.interopx.platform.datametrics.model.StudentEntity;

/**
 * The Interface StudentService.
 */
public interface StudentService {
	StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException;
	List<StudentEntity> getAllStudents();
	StudentEntity getStudentById(Long id) throws RecordNotFoundException;
}
