package com.example.bugreporttool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotBlank(message = "Description must not be empty")
    @Size(max = 2000, message = "Description must be less than 2000 characters")
    @Column(length = 2000)
    private String description;

    @NotBlank(message = "Priority must not be empty")
    private String priority;

    @NotBlank(message = "Status must not be empty")
    private String status;

    @NotBlank(message = "Reporter email must not be empty")
    @Email(message = "Email should be valid")
    private String reporterEmail;

    private LocalDate dateCreated;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReporterEmail() { return reporterEmail; }
    public void setReporterEmail(String reporterEmail) { this.reporterEmail = reporterEmail; }

    public LocalDate getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDate dateCreated) { this.dateCreated = dateCreated; }

    @PrePersist
    protected void onCreate() {
        this.dateCreated = LocalDate.now();
    }
}
