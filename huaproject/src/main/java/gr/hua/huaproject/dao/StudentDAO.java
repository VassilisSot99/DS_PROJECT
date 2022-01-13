package gr.hua.huaproject.dao;


import gr.hua.huaproject.entity.Course;

import java.util.List;

public interface StudentDAO {
    public List<Course> getCourses();
    public void newApplication();

}
