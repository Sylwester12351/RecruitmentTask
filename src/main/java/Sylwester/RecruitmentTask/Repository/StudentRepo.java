package Sylwester.RecruitmentTask.Repository;

import Sylwester.RecruitmentTask.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student , Long> {
    Student findByName(String name);
    Student findByLastName(String lastName);
}
