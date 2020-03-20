package com.interopx.platform.datametrics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interopx.platform.datametrics.dao.StudentDao;
import com.interopx.platform.datametrics.exceptions.RecordNotFoundException;
import com.interopx.platform.datametrics.model.StudentEntity;

/**
 * The Class MetricsServiceImpl.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException {
		return studentDao.createOrUpdateStudent(entity);
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public StudentEntity getStudentById(Long id) throws RecordNotFoundException {
		return studentDao.getStudentById(id);
	}
	
}
