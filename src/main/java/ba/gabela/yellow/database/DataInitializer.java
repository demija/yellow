package ba.gabela.yellow.database;

import ba.gabela.yellow.service.impl.InitializationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private InitializationServiceImpl initializationService;

    @Override
    public void run(ApplicationArguments args) {
        initializationService.initializeData();
    }
}
