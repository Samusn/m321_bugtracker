package ch.clip.bugtracker.application;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;
    private final RestTemplate restTemplate;
    private static final String USER_SERVICE_URL = "http://localhost:8083/persons/";

    public ApplicationController(ApplicationRepository applicationRepository, RestTemplate restTemplate) {
        this.applicationRepository = applicationRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}/with-owner")
    public Map<String, Object> getApplicationWithOwner(@PathVariable Integer id) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id", app.getId());
        result.put("name", app.getName());
        result.put("description", app.getDescription());
        result.put("owner_id", app.getOwner_id());

        try {
            Map owner = restTemplate.getForObject(USER_SERVICE_URL + app.getOwner_id(), Map.class);
            result.put("owner", owner);
        } catch (Exception e) {
            result.put("owner", "UserManagement service unavailable");
        }

        return result;
    }
}
