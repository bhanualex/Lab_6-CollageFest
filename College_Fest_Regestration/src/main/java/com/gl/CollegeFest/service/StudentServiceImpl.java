package com.gl.CollegeFest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.CollegeFest.entity.Student;
import com.gl.CollegeFest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		Student theStudent = null;
		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			// we didn't find the Student
			throw new RuntimeException("Student Not Found with given roll Number: " + theId);
		}
		return theStudent;
	}

	@Override
	public void save(Student theBook) {
		studentRepository.save(theBook);

	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);

	}

}
