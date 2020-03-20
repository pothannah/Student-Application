package com.interopx.platform.datametrics.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.interopx.platform.datametrics.exceptions.RecordNotFoundException;
import com.interopx.platform.datametrics.model.StudentEntity;


@Repository
public class StudentDaoImpl extends AbstractDao implements StudentDao {

	@Override
	public StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		Criteria criteria = getSession().createCriteria(StudentEntity.class);
		List<StudentEntity> studentList = criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY).list();

		return studentList;
	}

	@Override
	public StudentEntity getStudentById(Long id) throws RecordNotFoundException {
		StudentEntity student = (StudentEntity) getSession().get(StudentEntity.class, id);
		return student;
	}

}
