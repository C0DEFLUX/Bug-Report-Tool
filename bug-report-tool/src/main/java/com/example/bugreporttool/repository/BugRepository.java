package com.example.bugreporttool.repository;


import com.example.bugreporttool.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long>
{
}
