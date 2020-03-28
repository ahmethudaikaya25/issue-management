package com.ahmethkaya.issuemanagement.service.impl;

import com.ahmethkaya.issuemanagement.dto.ProjectDto;
import com.ahmethkaya.issuemanagement.entity.Project;
import com.ahmethkaya.issuemanagement.repository.ProjectRepository;
import com.ahmethkaya.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;



    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper){
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null)
            throw new IllegalArgumentException("Project Code Already Exist");

        Project p = modelMapper.map(project,Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if(projectDb==null)
            throw new IllegalArgumentException("Project does not exist ID: "+id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        //project check zaten veritabanında varsa ve dbdeki veritabanına eşit değilse
        if(projectCheck!=null)
            throw new IllegalArgumentException("Project Code Already Exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
