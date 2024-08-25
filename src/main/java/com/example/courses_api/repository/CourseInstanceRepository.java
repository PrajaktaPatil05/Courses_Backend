package com.example.courses_api.repository;

import com.example.courses_api.model.CourseInstance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
	List<CourseInstance> findByYearAndSemester(int year, int semester);
	//List<CourseInstance> findAllByYearAndSemesterAndCourseId(int year, int semester, Long courseId);
	void deleteAllByYearAndSemesterAndCourseId(int year, int semester, Long courseId);
	CourseInstance findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);
}