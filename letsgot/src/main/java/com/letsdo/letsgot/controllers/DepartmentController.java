package com.letsdo.letsgot.controllers;


import com.letsdo.letsgot.dto.DepartmentDto;
import com.letsdo.letsgot.entities.DepartmentEntities;
import com.letsdo.letsgot.repository.DepartmentRepository;
import com.letsdo.letsgot.services.DepartmentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")

public class DepartmentController {


private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping(path= "/{departmentId}")
    public DepartmentDto getDepartmentById(@PathVariable (name = "departmentId") Long id){
        return departmentServices.getDepartmentById(id);


    }

    @GetMapping
    public List<DepartmentDto> getAllDepartment(@RequestParam(required = false) Long id,
                                                     @RequestParam(required = false)String title)

    {
        return departmentServices.getAllDepartment();

    }
@PostMapping
    public List<DepartmentDto> createNewDepartment(@RequestBody List<DepartmentDto >inputDepartment){

        return  departmentServices.createNewDepartment(inputDepartment);

}

@PutMapping("/{id}")
public DepartmentDto updateDepartmentById(   @PathVariable Long id,
                                              @RequestBody DepartmentDto  departmentDto){

    return departmentServices.updateDepartmentById(id,departmentDto);

}

    @PatchMapping("/{id}")
    public DepartmentDto updateDepartmentPartiallyById(   @PathVariable Long id,
                                                 @RequestBody DepartmentDto  departmentDto){

        return departmentServices.updateDepartmentPartiallyById(id,departmentDto);

    }

    @DeleteMapping("/{id}")
    public DepartmentDto deleteDepartmentById(   @PathVariable Long id){


        return departmentServices.deleteDepartmentById(id);

    }

}
