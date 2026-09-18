package ch.clip.bugtracker.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class ApplicationCatalogApplication {
    private Logger log = Logger.getLogger(String.valueOf(ApplicationCatalogApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(ApplicationCatalogApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner demoData(ApplicationRepository applicationRepository) {
        return (args) -> {
            Application app1 = new Application("Bugtracker", "Bug tracking system", 1);
            Application app2 = new Application("Wiki", "Internal documentation platform", 2);
            Application app3 = new Application("CRM", "Customer relationship management", 3);
            Application app4 = new Application("HRM", "Human resource management", 4);
            Application app5 = new Application("ERP", "Enterprise resource planning", 5);

            applicationRepository.save(app1);
            applicationRepository.save(app2);
            applicationRepository.save(app3);
            applicationRepository.save(app4);
            applicationRepository.save(app5);

            log.info("Saved Application id: " + app1.getId());
            log.info("Saved Application id: " + app2.getId());
            log.info("Saved Application id: " + app3.getId());
            log.info("Saved Application id: " + app4.getId());
            log.info("Saved Application id: " + app5.getId());
        };
    }
}
