package com.example.courses_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courses_api.model.CourseInstance;
import com.example.courses_api.repository.CourseInstanceRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseInstanceService {

  @Autowired
  private CourseInstanceRepository courseInstanceRepository;

  public CourseInstance createCourseInstance(CourseInstance courseInstance) {
      return courseInstanceRepository.save(courseInstance);
  }
  public List<CourseInstance> getCoursesByYearAndSemester(int year, int semester) {
      return courseInstanceRepository.findByYearAndSemester(year, semester);
  }
  
//  public List<CourseInstance> getCourseInstanceDetails(int year, int semester, Long courseId) {
//		return courseInstanceRepository.findAllByYearAndSemesterAndCourseId(year, semester, courseId);
//}

  public CourseInstance getCourseInstanceDetails(int year, int semester, Long courseId) {
		return courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, courseId);
}

  @Transactional
  public void deleteCourseInstance(int year, int semester, Long courseId) {
	  this.courseInstanceRepository.deleteAllByYearAndSemesterAndCourseId(year, semester, courseId);
	  
  }
}