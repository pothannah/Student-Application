package com.interopx.platform.datametrics.dao;

import java.util.List;

import com.interopx.platform.datametrics.exceptions.RecordNotFoundException;
import com.interopx.platform.datametrics.model.StudentEntity;

public interface StudentDao {
	StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException;
	List<StudentEntity> getAllStudents();
	StudentEntity getStudentById(Long id) throws RecordNotFoundException;

}
