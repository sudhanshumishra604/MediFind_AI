package com.sudhanshu.medifind.service;

import com.sudhanshu.medifind.dto.request.PatientRegisterRequest;
import com.sudhanshu.medifind.dto.response.DoctorResponse;
import com.sudhanshu.medifind.dto.response.PatientResponse;
import java.util.List;

public interface PatientService {
    List<DoctorResponse> getAllPatients();

    PatientResponse registerPatient(PatientRegisterRequest request);

    PatientResponse getProfile();
}
