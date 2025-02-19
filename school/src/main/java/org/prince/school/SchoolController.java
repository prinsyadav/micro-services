package org.prince.school;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping("/all")
    public Iterable<School> getAllSchool() {
        return schoolService.getAllSchool();
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable("schoolId") Integer schoolId
    ) {
        return ResponseEntity.ok(schoolService.getSchoolWithStudents(schoolId));
    }
}
