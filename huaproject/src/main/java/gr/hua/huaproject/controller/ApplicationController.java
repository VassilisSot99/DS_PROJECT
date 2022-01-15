package gr.hua.huaproject.controller;

import gr.hua.huaproject.entity.Application;
import gr.hua.huaproject.repository.ApplicationRepository;
import gr.hua.huaproject.repository.ApplicationRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationRepositoryCustom applicationRepositoryCustom;


    @GetMapping()
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }



    @GetMapping("/tobechecked")
    public List<Application> getApplicationsToBeChecked() {
        return applicationRepositoryCustom.getApplicationsToBeChecked();
    }

    @GetMapping("/tobeevaluated")
    public List<Application> getApplicationsToBeEvaluated() {
        return applicationRepositoryCustom.getApplicationsToBeEvaluated();
    }

    @GetMapping("/{id}")
    public Application retrieveApplication(@PathVariable int id) {
        Optional<Application> application = applicationRepository.findById(id);

        if (!application.isPresent())
            throw new ApplicationNotFoundException("id-" + id);

        return application.get();
    }

    @PutMapping("/{id}/{string}")
    public ResponseEntity<Object> updateApplication(@RequestBody Application application, @PathVariable int id, @PathVariable String string) {

        Optional<Application> applicationOptional = applicationRepository.findById(id);

        if (!applicationOptional.isPresent())
            return ResponseEntity.notFound().build();

        application.setChecked(string);

        applicationRepository.save(application);

        return ResponseEntity.noContent().build();

    }

}
