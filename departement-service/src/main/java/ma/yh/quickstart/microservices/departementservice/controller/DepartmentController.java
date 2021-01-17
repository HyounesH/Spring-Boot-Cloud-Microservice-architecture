package ma.yh.quickstart.microservices.departementservice.controller;

import lombok.extern.slf4j.Slf4j;
import ma.yh.quickstart.microservices.departementservice.model.Department;
import ma.yh.quickstart.microservices.departementservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        log.info(" Inside saveDepartment method of DepartmentController class");
        return ResponseEntity.ok(departmentService.save(department));
    }

    @GetMapping("/findById/{departmentId}")
    public ResponseEntity<Department> findById(@PathVariable("departmentId") Long departmentId) {
        log.info(" Inside findById method of DepartmentController class");
        return ResponseEntity.ok(departmentService.findById(departmentId));
    }
}
