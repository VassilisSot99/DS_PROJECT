package gr.hua.huaproject.repository;

import gr.hua.huaproject.entity.Application;
import org.hibernate.query.Query;

import java.util.List;

public interface ApplicationRepositoryCustom {
    public List<Application> getApplicationsToBeChecked();
    public List<Application> getApplicationsToBeEvaluated();
}
