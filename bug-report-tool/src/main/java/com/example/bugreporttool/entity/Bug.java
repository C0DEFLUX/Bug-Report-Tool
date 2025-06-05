package com.example.bugreporttool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Description is required.")
    @Column(length = 2000)
    private String description;

    private String priority;

    private String status;

    @Email(message = "Please enter a valid email.")
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
