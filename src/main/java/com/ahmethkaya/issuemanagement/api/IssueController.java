package com.ahmethkaya.issuemanagement.api;

import com.ahmethkaya.issuemanagement.dto.IssueDto;
import com.ahmethkaya.issuemanagement.service.impl.IssueServiceImpl;
import com.ahmethkaya.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    /**
     * Http methodları
     * get
     * post
     * put
     * delete
     */

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    //http get met
    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    //
    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }


    //  @RequestMapping(path = "/update", method = RequestMethod.PUT)
    @PutMapping(path = "/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issue));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

}
