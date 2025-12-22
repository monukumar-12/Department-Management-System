package com.letsdo.letsgot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentDto {

   private Long departmentId;
    private  String title;
    private  Boolean isActive;
    private LocalDateTime createdAt;

}
