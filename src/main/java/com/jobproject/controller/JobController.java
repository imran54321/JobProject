package com.jobproject.controller;
import com.jobproject.entities.Job;
import com.jobproject.response.JobResponse;
import com.jobproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobDetails")
public class JobController {
    @Autowired
    private JobService jobService;
    @PostMapping()
    public String createJob(@RequestBody Job job){
       this.jobService.createJob(job);
       return "job created successfully";
    }
    @PutMapping()
    public String updateJob(@RequestBody Job job){
        this.jobService.updateJob(job);
        return "job updated successfully";
    }
    @DeleteMapping("/{jobId}")
    public String deleteJob(@PathVariable("jobId") int jobId){
        this.jobService.deleteJob(jobId);
        return "job deleted successfully";
    }
    @GetMapping()
    public List<Job> getJob(){

       return this.jobService.getAllJob();
    }
    @GetMapping("/{jobId}")
    public ResponseEntity<Object> getJob(@PathVariable("jobId") int jobId)
    {
       return JobResponse.responseBuilder("Requested job details are given here ", HttpStatus.OK,this.jobService.getJob(jobId));
       // return  this.jobService.getJob(jobId);

    }
}
