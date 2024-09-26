package com.zoroapp.scheduler.scheduling.services;


import com.zoroapp.scheduler.scheduling.models.Job;
import com.zoroapp.scheduler.scheduling.models.JobDTO;
import jakarta.persistence.NoResultException;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<JobDTO> getAllJobs();

    Job addNewJob(Job job) throws Exception;

    public Job getJobById(long id);

    public boolean jobExists(long id);

    public Job updateJobDetails(long id, Job job);

    public long deleteJob(long id);
}
