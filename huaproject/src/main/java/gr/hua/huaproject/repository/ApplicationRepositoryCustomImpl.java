package gr.hua.huaproject.repository;

import gr.hua.huaproject.entity.Application;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ApplicationRepositoryCustomImpl implements ApplicationRepositoryCustom{

    private EntityManager entityManager;

    @Autowired
    public ApplicationRepositoryCustomImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;

    }

    @Override
    @Transactional
    public List<Application> getApplicationsToBeChecked() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Application> theQuery = currentSession.createQuery("from Application app where app.checked='null'", Application.class);

        List<Application> applicationsToBeChecked = theQuery.getResultList();

        return applicationsToBeChecked;
    }

    @Override
    @Transactional
    public List<Application> getApplicationsToBeEvaluated() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Application> theQuery = currentSession.createQuery("from Application app where " +
                "app.checked='true'" + " AND app.evaluated='null'", Application.class);

        List<Application> applicationsToBeEvaluated = theQuery.getResultList();

        return applicationsToBeEvaluated;
    }
}
