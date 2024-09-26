package com.zoroapp.scheduler.scheduling.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String jobName;
    @Column
    private String jobType;
    @Column
    private String scheduleType;
    @Column
    private String jobParameters;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;
    @Column
    private String status;
    @Column
    private String jobOwner;
}
