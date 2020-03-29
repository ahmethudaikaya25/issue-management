package com.ahmethkaya.issuemanagement.service.impl;

import com.ahmethkaya.issuemanagement.dto.IssueDto;
import com.ahmethkaya.issuemanagement.entity.Issue;
import com.ahmethkaya.issuemanagement.repository.IssueRepository;
import com.ahmethkaya.issuemanagement.service.IssueService;
import com.ahmethkaya.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {

        if(issue.getDate() == null)
            throw new IllegalArgumentException("Issue Date cannot be null");

        Issue issueDb = modelMapper.map(issue,Issue.class); //dtodan aldığı verileri issue ile işleştirip döndürür
        issueDb = issueRepository.save(issueDb); //veritabanına kaydet
        return modelMapper.map(issueDb,IssueDto.class); //sonra dışarı verirken Dtoyu göndeririz
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data,Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto issue) {
        return null;
    }
}
