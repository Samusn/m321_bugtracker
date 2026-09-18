package ch.clip.bugtracker.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class UserApplication {
    private Logger log = Logger.getLogger(String.valueOf(UserApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(PersonRepository personRepository) {
        return (args) -> {
            Person p1 = new Person("Alice", "Smith", "alice.smith@example.com", "Developer");
            Person p2 = new Person("Bob", "Jones", "bob.jones@example.com", "Manager");
            Person p3 = new Person("Charlie", "Brown", "charlie.brown@example.com", "Tester");
            Person p4 = new Person("Diana", "Prince", "diana.prince@example.com", "Developer");
            Person p5 = new Person("Eve", "Taylor", "eve.taylor@example.com", "Admin");

            personRepository.save(p1);
            personRepository.save(p2);
            personRepository.save(p3);
            personRepository.save(p4);
            personRepository.save(p5);

            log.info("Saved Person id: " + p1.getId());
            log.info("Saved Person id: " + p2.getId());
            log.info("Saved Person id: " + p3.getId());
            log.info("Saved Person id: " + p4.getId());
            log.info("Saved Person id: " + p5.getId());
        };
    }
}
