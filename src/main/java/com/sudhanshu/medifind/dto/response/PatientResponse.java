package com.sudhanshu.medifind.dto.response;

import com.sudhanshu.medifind.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PatientResponse {

    private String fullName;
    private String email;
    private Gender gender;
    private Integer age;
    }
