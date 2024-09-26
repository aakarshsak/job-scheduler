package com.zoroapp.scheduler.scheduling.controllers;

import com.zoroapp.scheduler.scheduling.models.Job;
import com.zoroapp.scheduler.scheduling.models.JobDTO;
import com.zoroapp.scheduler.scheduling.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {


    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("")
    public ResponseEntity<Job> addJob(@RequestBody Job job) throws Exception {
        return new ResponseEntity<>(jobService.addNewJob(job), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobDetail(@PathVariable long id) {
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<JobDTO>> getAllJobsList() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJobDetails(@PathVariable long id, @RequestBody Job job) {
        job = jobService.updateJobDetails(id, job);
        return new ResponseEntity<>(job, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public long deleteJob(@PathVariable long id) {
        return jobService.deleteJob(id);
    }
}
