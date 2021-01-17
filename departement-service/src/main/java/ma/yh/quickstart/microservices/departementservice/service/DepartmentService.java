package ma.yh.quickstart.microservices.departementservice.service;

import lombok.extern.slf4j.Slf4j;
import ma.yh.quickstart.microservices.departementservice.model.Department;
import ma.yh.quickstart.microservices.departementservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("Inside save method of DepartmentService class");
        return departmentRepository.save(department);
    }

    public Department findById(Long departmentId) {
        log.info("Inside findById method of DepartmentService class");
        return departmentRepository.findById(departmentId).get();
    }
}
