package com.zoroapp.scheduler.scheduling.repositories;

import com.zoroapp.scheduler.scheduling.models.Job;
import com.zoroapp.scheduler.scheduling.models.JobDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobsRepository extends JpaRepository<Job, Long> {

    @Query("SELECT new com.zoroapp.scheduler.scheduling.models.JobDTO(j.id, j.jobName) FROM Job j")
    List<JobDTO> findAllJobList();
}
