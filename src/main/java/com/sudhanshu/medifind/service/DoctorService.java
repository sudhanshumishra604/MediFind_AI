package com.sudhanshu.medifind.service;

import com.sudhanshu.medifind.dto.DoctorResponse;

import java.util.List;

public interface DoctorService {

    List<DoctorResponse> getAllDoctors();

}