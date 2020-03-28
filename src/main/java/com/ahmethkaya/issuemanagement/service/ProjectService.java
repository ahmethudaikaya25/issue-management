package com.ahmethkaya.issuemanagement.service;

import com.ahmethkaya.issuemanagement.dto.ProjectDto;
import com.ahmethkaya.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(ProjectDto project);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto project);
}
