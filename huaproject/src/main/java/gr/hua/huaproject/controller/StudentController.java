package gr.hua.huaproject.controller;

import gr.hua.huaproject.entity.Application;
import gr.hua.huaproject.entity.Course;
import gr.hua.huaproject.entity.Student;
import gr.hua.huaproject.repository.ApplicationRepository;
import gr.hua.huaproject.repository.CourseRepository;
import gr.hua.huaproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping()
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

   @PostMapping()
   public ResponseEntity<Object> newApplication(@RequestBody Application application) {
       Application savedApplication = applicationRepository.save(application);
       System.out.println("student id " + savedApplication.getId());


       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(savedApplication.getId()).toUri();

       return ResponseEntity.created(location).build();
   }

   /*@PostMapping()
   public void newApplication(@RequestBody Application application) {
        applicationRepository.save(application);
   }*/

}
