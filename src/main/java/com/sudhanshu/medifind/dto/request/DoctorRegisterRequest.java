package com.sudhanshu.medifind.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRegisterRequest {

    private String fullName;

    private String email;

    private String password;

    private String specialization;

    private Integer experience;

    private String hospital;

    private String city;

    private Double consultationFee;

    private String about;

}