package com.ahmethkaya.issuemanagement.service;

import com.ahmethkaya.issuemanagement.dto.IssueDto;
import com.ahmethkaya.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id); //veritabanından id bilgisiyle bilgi çekecek

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

    Boolean delete(Long id);

    IssueDto update(Long id, IssueDto issue);

}
