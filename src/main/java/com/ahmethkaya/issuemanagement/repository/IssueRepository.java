package com.ahmethkaya.issuemanagement.repository;

import com.ahmethkaya.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    void deleteById(Long id);
}
