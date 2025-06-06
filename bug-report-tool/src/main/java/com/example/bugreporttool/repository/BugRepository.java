package com.example.bugreporttool.repository;


import com.example.bugreporttool.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long>
{
}
