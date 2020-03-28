package com.ahmethkaya.issuemanagement.api;


import com.ahmethkaya.issuemanagement.dto.ProjectDto;
import com.ahmethkaya.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {
    /**
     * Http methodları
     * get
     * post
     * put
     * delete
     */

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    //http get met
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }

    //
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }


    //  @RequestMapping(path = "/update", method = RequestMethod.PUT)
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }

}
