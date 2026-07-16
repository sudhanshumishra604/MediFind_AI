package com.sudhanshu.medifind.service.implementation;

import com.sudhanshu.medifind.dto.request.PatientRegisterRequest;
import com.sudhanshu.medifind.dto.response.DoctorResponse;
import com.sudhanshu.medifind.dto.response.PatientResponse;
import com.sudhanshu.medifind.entity.Patient;
import com.sudhanshu.medifind.entity.Role;
import com.sudhanshu.medifind.entity.User;
import com.sudhanshu.medifind.repository.PatientRepository;
import com.sudhanshu.medifind.repository.UserRepository;
import com.sudhanshu.medifind.service.PatientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public PatientServiceImpl(UserRepository userRepository, PatientRepository patientRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<DoctorResponse> getAllPatients() {
        return null;
    }
    @Override
    public PatientResponse registerPatient(PatientRegisterRequest request) {
        User user = new User();
        Patient patient = new Patient();
        PatientResponse response = new PatientResponse();

        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setRole(Role.PATIENT);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User saveduser = userRepository.save(user);

        patient.setFullName(request.getFullName());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setUser(saveduser);
        patientRepository.save(patient);


        response.setFullName(request.getFullName());
        response.setAge(request.getAge());
        response.setGender(request.getGender());
        response.setEmail(request.getEmail());

        return response;
    }

    @Override
    public PatientResponse getProfile() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();
        Patient patient = patientRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return PatientResponse.builder()
                .fullName(patient.getFullName())
                .email(user.getEmail())
                .gender(patient.getGender())
                .age(patient.getAge())
                .build();
    }
}
