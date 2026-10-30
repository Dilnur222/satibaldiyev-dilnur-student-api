package com.satibaldiyev.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort private int port;
    @Autowired private TestRestTemplate rest;

    private String url() { return "http://localhost:" + port + "/api/students"; }

    @Test
    void studentCrudWorkflow() {
        Student input = new Student();
        input.setName("Dilnur");
        input.setSurname("Satibaldiyev");
        input.setGroupName("IT2-2304");
        input.setStudentId(38036);

        ResponseEntity<Student> created = rest.postForEntity(url(), input, Student.class);
        assertEquals(HttpStatus.CREATED, created.getStatusCode());
        assertNotNull(created.getBody());
        Long id = created.getBody().getId();
        assertNotNull(id);

        Student loaded = rest.getForObject(url() + "/" + id, Student.class);
        assertNotNull(loaded);
        assertEquals("Dilnur", loaded.getName());

        input.setGroupName("IT2-2304-Updated");
        rest.put(url() + "/" + id, input);
        Student updated = rest.getForObject(url() + "/" + id, Student.class);
        assertNotNull(updated);
        assertEquals("IT2-2304-Updated", updated.getGroupName());

        rest.delete(url() + "/" + id);
        ResponseEntity<String> missing = rest.getForEntity(url() + "/" + id, String.class);
        assertEquals(HttpStatus.NOT_FOUND, missing.getStatusCode());
    }

    @Test
    void missingStudentReturnsNotFound() {
        ResponseEntity<String> response = rest.getForEntity(url() + "/999999", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
