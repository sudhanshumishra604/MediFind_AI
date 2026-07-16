package com.sudhanshu.medifind.dto.request;


import com.sudhanshu.medifind.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRegisterRequest {
    private String email;
    private String password;
    private String fullName;
    private Integer age;
    private Gender gender;

}
