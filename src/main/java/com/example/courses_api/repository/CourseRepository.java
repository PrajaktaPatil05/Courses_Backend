package com.example.courses_api.repository;


import com.example.courses_api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
  // No additional methods are required; JpaRepository provides all basic CRUD operations.
}
