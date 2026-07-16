package com.sudhanshu.medifind.service;

import com.sudhanshu.medifind.dto.request.DoctorRegisterRequest;
import com.sudhanshu.medifind.dto.response.DoctorResponse;

import java.util.List;

public interface DoctorService {

    List<DoctorResponse> getAllDoctors();
    DoctorResponse registerDoctor(DoctorRegisterRequest request);

    DoctorResponse getProfile();
}