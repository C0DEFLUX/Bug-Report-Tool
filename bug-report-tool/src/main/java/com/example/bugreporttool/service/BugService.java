package com.example.bugreporttool.service;

import com.example.bugreporttool.entity.Bug;
import com.example.bugreporttool.repository.BugRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BugService {

    private final BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public List<Bug> getAllBugs()
    {
        return bugRepository.findAll(Sort.by(Sort.Direction.DESC, "dateCreated"));
    }

    public Bug getBugById(Long id)
    {
        return bugRepository.findById(id).orElse(null);
    }

    public Bug saveBug(Bug bug)
    {
        if (bug.getDateCreated() == null) {
            bug.setDateCreated(LocalDate.now());
        }
        return bugRepository.save(bug);
    }

    public void deleteBug(Long id)
    {
        bugRepository.deleteById(id);
    }

    public Bug updateBug(Long id, Bug updatedBug) {
        return bugRepository.findById(id).map(existingBug -> {
            if (updatedBug.getTitle() != null) {
                existingBug.setTitle(updatedBug.getTitle());
            }
            if (updatedBug.getDescription() != null) {
                existingBug.setDescription(updatedBug.getDescription());
            }
            if (updatedBug.getPriority() != null) {
                existingBug.setPriority(updatedBug.getPriority());
            }
            if (updatedBug.getStatus() != null) {
                existingBug.setStatus(updatedBug.getStatus());
            }
            if (updatedBug.getReporterEmail() != null) {
                existingBug.setReporterEmail(updatedBug.getReporterEmail());
            }
            return bugRepository.save(existingBug);
        }).orElse(null);
    }
}
