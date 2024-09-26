package com.zoroapp.scheduler.scheduling.services;

import com.zoroapp.scheduler.scheduling.exceptions.DuplicateJobException;
import com.zoroapp.scheduler.scheduling.models.Job;
import com.zoroapp.scheduler.scheduling.models.JobDTO;
import com.zoroapp.scheduler.scheduling.repositories.JobsRepository;
import jakarta.persistence.NoResultException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImpl implements JobService{

    private JobsRepository jobsRepository;

    @Autowired
    public JobServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<JobDTO> jobs = jobsRepository.findAllJobList();
        System.out.println(jobs);

        List<Job> list = new ArrayList<>();
        return jobs;
    }

    @Override
    public Job getJobById(long id) {
        Optional<Job> searchedJob = jobsRepository.findById(id);
        if(!searchedJob.isPresent()) {
            throw new NoResultException("no data for this id");
        }

        return searchedJob.get();
    }

    @Override
    public boolean jobExists(long id) {
        Optional<Job> searchedJob = jobsRepository.findById(id);
        return searchedJob.isPresent();
    }



    @Override
    public Job addNewJob(Job job) {
        long id = job.getId();
        Date date = new Date(System.currentTimeMillis());
        job.setCreatedAt(date);
        job.setUpdatedAt(date);
        if(jobExists(id)) {
            throw new DuplicateJobException("Job Already exist");
        }
        return jobsRepository.saveAndFlush(job);
    }

    @Override
    public Job updateJobDetails(long id, Job job) {
        if(!jobExists(id)) {
            throw new NoResultException("Job does not exist");
        }
        job.setId(id);
        Date date = new Date(System.currentTimeMillis());
        job.setUpdatedAt(date);
        return jobsRepository.save(job);
    }

    @Override
    public long deleteJob(long id) {
        if(!jobExists(id)) {
            throw new NoResultException("Job does not exist");
        }
        jobsRepository.deleteById(id);

        return id;
    }
}
