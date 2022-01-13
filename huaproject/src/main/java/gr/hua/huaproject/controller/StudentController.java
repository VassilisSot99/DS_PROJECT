package gr.hua.huaproject.controller;

import gr.hua.huaproject.dao.StudentDAO;
import gr.hua.huaproject.dao.StudentDAOImpl;
import gr.hua.huaproject.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping ("/")
    public String getCourseList(Model model){
        List<Course> courses = studentDAO.getCourses();
        model.addAttribute("courses", courses);
        return "it works";
    }
}
