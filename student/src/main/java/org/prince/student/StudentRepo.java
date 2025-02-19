package org.prince.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findBySchoolId(Integer schoolId);
}
