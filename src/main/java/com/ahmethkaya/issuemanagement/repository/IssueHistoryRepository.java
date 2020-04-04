package com.ahmethkaya.issuemanagement.repository;

import com.ahmethkaya.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {


}
