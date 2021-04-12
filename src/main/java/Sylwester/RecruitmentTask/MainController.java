package Sylwester.RecruitmentTask;

import Sylwester.RecruitmentTask.Entity.Student;
import Sylwester.RecruitmentTask.Entity.Teacher;
import Sylwester.RecruitmentTask.Repository.StudentRepo;
import Sylwester.RecruitmentTask.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    StringBuilder result = new StringBuilder();

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @PostMapping("/addNewStudent")
    public String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam String email, @RequestParam String course){
        Student student = new Student();
        if (age >= 18 && firstName.length() > 2 && lastName.length() > 2){
            student.setName(firstName);
            student.setLastName(lastName);
            student.setAge(age);
        }else {
            return "error";
        }
        student.setEmail(email);
        student.setCourse(course);
        studentRepo.save(student);

        for (Student i: studentRepo.findAll()){
            result.append(i).append("<br>");
        }
        return result.toString();

    }
    @PostMapping("/addNewTeacher")
    public String addTeacher(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam String email, @RequestParam String subject){
        Teacher teacher = new Teacher();
        if (age >= 18 && firstName.length() > 2 && lastName.length() > 2){
            teacher.setName(firstName);
            teacher.setLastName(lastName);
            teacher.setAge(age);
        }else {
            return "error";
        }
        teacher.setEmail(email);
        teacher.setSubject(subject);
        teacherRepo.save(teacher);

        for (Teacher i: teacherRepo.findAll()){
            result.append(i).append("<br>");
        }
        return result.toString();

    }
    @PostMapping ("/deleteStudent")
    public void deleteStudent(Long id){
        studentRepo.deleteById(id);

    }
    @PostMapping ("/deleteTeacher")
    public void deleteTeacher(Long id){
        teacherRepo.deleteById(id);
    }

}
