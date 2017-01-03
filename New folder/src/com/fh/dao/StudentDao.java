package com.fh.dao;
import java.util.List;

import com.fh.domain.Student;

public interface StudentDao extends Dao<Student>{
	public abstract List<Student> retriveAllStudents();
}
