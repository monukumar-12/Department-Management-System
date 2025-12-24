package com.letsdo.letsgot.services;


import com.letsdo.letsgot.dto.DepartmentDto;
import com.letsdo.letsgot.entities.DepartmentEntities;
import com.letsdo.letsgot.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {

    private final DepartmentRepository departmentRepository;
    public final ModelMapper modelMapper;

    public DepartmentServices(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public DepartmentDto getDepartmentById(Long id) {
        DepartmentEntities departmentEntities = departmentRepository.findById(id).orElse(null);
        return modelMapper.map(departmentEntities,DepartmentDto.class);

    }

    public List<DepartmentDto> getAllDepartment() {
        List<DepartmentEntities> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDto.class))
                .toList();
    }

    public List<DepartmentDto> createNewDepartment(List<DepartmentDto> inputDepartment) {
        List<DepartmentEntities> entities = inputDepartment.stream()
                .map(dto -> modelMapper.map(dto,DepartmentEntities.class)).toList();

        List<DepartmentEntities> saveEntities = departmentRepository.saveAll(entities);
        return saveEntities.stream()
                .map(departmentEntities -> modelMapper.map(departmentEntities,DepartmentDto.class)).toList();

    }

    public DepartmentDto updateDepartmentById(Long id, DepartmentDto departmentDto) {
        DepartmentEntities departmentEntities =departmentRepository.findById(id).orElseThrow();

        departmentEntities.setTitle(departmentDto.getTitle());
        departmentEntities.setIsActive(departmentDto.getIsActive());

        departmentRepository.save(departmentEntities);

        return modelMapper.map(departmentEntities,DepartmentDto.class);
    }

    public DepartmentDto updateDepartmentPartiallyById(Long id, DepartmentDto departmentDto) {

        DepartmentEntities departmentEntities = departmentRepository.findById(id).orElseThrow();
        if (departmentDto.getTitle() != null) {
            departmentEntities.setTitle(departmentDto.getTitle());
        }

        if (departmentDto.getIsActive() != null) {
            departmentEntities.setIsActive(departmentDto.getIsActive());
        }

        DepartmentEntities updatedDepartment= departmentRepository.save(departmentEntities);

     return    modelMapper.map(updatedDepartment,DepartmentDto.class);


    }

    public DepartmentDto deleteDepartmentById(Long id) {
        DepartmentEntities departmentEntities = departmentRepository.findById(id).orElseThrow();
        departmentRepository.delete(departmentEntities);
    return modelMapper.map(departmentEntities,DepartmentDto.class);

    }


//public List<DepartmentDto> createNewDepartment(List<DepartmentDto> inputDepartment) {
//
//    // DTO → Entity
//    List<DepartmentEntities> entities = inputDepartment.stream()
//            .map(dto -> modelMapper.map(dto, DepartmentEntities.class))
//            .toList();
//
//    // saveAll expects List<Entity>
//    List<DepartmentEntities> savedEntities =
//            departmentRepository.saveAll(entities);
//
//    // Entity → DTO
//    return savedEntities.stream()
//            .map(entity -> modelMapper.map(entity, DepartmentDto.class))
//            .toList();
//}




}
