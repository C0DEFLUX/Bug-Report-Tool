package com.example.bugreporttool.controller;

import com.example.bugreporttool.entity.Bug;
import com.example.bugreporttool.service.BugService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BugController
{
    private final BugService service;

    public BugController(BugService service)
    {
        this.service = service;
    }

    @GetMapping("/bugs")
    public ResponseEntity<List<Bug>> getAllBugs()
    {
        return ResponseEntity.ok(service.getAllBugs());
    }

    @PostMapping("/add-bug")
    public ResponseEntity<Bug> createBug(@Valid @RequestBody Bug bug)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveBug(bug));
    }

    @GetMapping("/get-bug-by-id/{id}")
    public ResponseEntity<Bug> getBugById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getBugById(id));
    }

    @PutMapping("/update-bug/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable Long id, @Valid @RequestBody Bug bug)
    {
        return ResponseEntity.ok(service.updateBug(id, bug));
    }

    @DeleteMapping("/delete-bug/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable Long id)
    {
        service.deleteBug(id);
        return ResponseEntity.noContent().build();
    }
}