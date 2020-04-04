package com.ahmethkaya.issuemanagement.service;

import com.ahmethkaya.issuemanagement.dto.IssueHistoryDto;
import com.ahmethkaya.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;


public interface IssueHistoryService {

    IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

}
