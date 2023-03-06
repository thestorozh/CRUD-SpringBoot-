package com.storozh.SpringExample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
}