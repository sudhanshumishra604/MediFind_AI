package com.sudhanshu.medifind.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;                          //Dto is of two type response and request
import lombok.Data;                             // Dto returns only needed data not whole entity
import lombok.NoArgsConstructor;                 // Dto used to deal with frontend
                                                 // protects sensitive data
                                                // Helps to decouple the Api if any change occur in future ->
                                                 // we can manage it without disturbing the design of code
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {

    private Long id;
    private String fullName;
    private String specialization;
    private String hospital;
    private String city;
    private Integer experience;
    private Double consultationFee;
    private Double rating;
}
