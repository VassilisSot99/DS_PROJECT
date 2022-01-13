package gr.hua.huaproject.dao;

import gr.hua.huaproject.entity.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;

    }

    @Override
    @Transactional
    public List<Course> getCourses() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);

        List<Course> courses = theQuery.getResultList();

        return courses;

    }

    @Override
    public void newApplication() {

    }
}
