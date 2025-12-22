package com.letsdo.letsgot.controllers;


import com.letsdo.letsgot.dto.DepartmentDto;
import com.letsdo.letsgot.entities.DepartmentEntities;
import com.letsdo.letsgot.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")

public class DepartmentController {


private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping(path= "/{departmentId}")
    public DepartmentEntities getAllDepartment(@PathVariable (name = "departmentId") Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<DepartmentEntities> getAllDepartment(@RequestParam(required = false) Long id,
                                                     @RequestParam(required = false)String title)

    {
        return departmentRepository.findAll();

    }
@PostMapping
    public List< DepartmentEntities> createNewDepartment(@RequestBody List<DepartmentEntities >inputDepartment){

        return  departmentRepository.saveAll(inputDepartment);

}

@PutMapping
public DepartmentDto updateDepartmentById(@RequestBody DepartmentDto  departmentId){

    return new DepartmentDto();

}

}
