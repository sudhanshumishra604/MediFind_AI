package com.sudhanshu.medifind.service.implementation;
                                                                  // Here in service layer we implement all thing
import com.sudhanshu.medifind.dto.DoctorResponse;            // All the rules are made here. It contains business logic
import com.sudhanshu.medifind.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<DoctorResponse> getAllDoctors() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
