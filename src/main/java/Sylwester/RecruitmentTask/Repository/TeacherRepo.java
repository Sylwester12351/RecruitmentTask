package Sylwester.RecruitmentTask.Repository;

import Sylwester.RecruitmentTask.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Teacher findByName(String name);
    Teacher findByLastName(String lastName);
}

