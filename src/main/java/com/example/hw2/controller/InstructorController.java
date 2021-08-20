package com.example.hw2.controller;

import com.example.hw2.model.Instructor;
import com.example.hw2.model.PermanentInstructor;
import com.example.hw2.model.VisitingResearcher;
import com.example.hw2.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/permanentInstructor")
    public ResponseEntity<Instructor> save(@RequestBody PermanentInstructor instructor) {
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.CREATED);
    }

    @PostMapping("/visitingResearcher")
    public ResponseEntity<Instructor> save(@RequestBody VisitingResearcher instructor) {
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.CREATED);
    }

    @PatchMapping("/permanentInstructor")
    public ResponseEntity<Instructor> update(@RequestBody PermanentInstructor instructor) {
        return new ResponseEntity<>(instructorService.update(instructor), HttpStatus.OK);
    }
    @PatchMapping("/visitingResearcher")
    public ResponseEntity<Instructor> update(@RequestBody VisitingResearcher instructor) {
        return new ResponseEntity<>(instructorService.update(instructor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        instructorService.deleteById(id);
    }

    @DeleteMapping("/permanentInstructor")
    public void deleteByObject(@RequestBody PermanentInstructor instructor) {
        instructorService.deleteByObject(instructor);
    }
    @DeleteMapping("/visitingResearcher")
    public void deleteByObject(@RequestBody VisitingResearcher instructor) {
        instructorService.deleteByObject(instructor);
    }
}
