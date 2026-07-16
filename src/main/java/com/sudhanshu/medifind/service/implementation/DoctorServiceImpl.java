package com.sudhanshu.medifind.service.implementation;
                                                                  // Here in service layer we implement all thing
import com.sudhanshu.medifind.dto.request.DoctorRegisterRequest;
import com.sudhanshu.medifind.dto.response.DoctorResponse;            // All the rules are made here. It contains business logic
import com.sudhanshu.medifind.entity.Doctor;
import com.sudhanshu.medifind.entity.Role;
import com.sudhanshu.medifind.entity.User;
import com.sudhanshu.medifind.repository.DoctorRepository;
import com.sudhanshu.medifind.repository.UserRepository;
import com.sudhanshu.medifind.service.DoctorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service                                                        // It tells spring to create bin and store in IOC container
public class DoctorServiceImpl implements DoctorService {
    private final UserRepository userRepository;          // Final keyword is used to make sure these object nedeed in service class and cannot be changed once allocated with value.
    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public DoctorServiceImpl(UserRepository userRepository, DoctorRepository doctorRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public List<DoctorResponse> getAllDoctors() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    @Override
    public DoctorResponse registerDoctor(DoctorRegisterRequest request) {
        User user = new User();
        Doctor doctor = new Doctor();
        DoctorResponse response = new DoctorResponse();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setRole(Role.DOCTOR);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        doctor.setSpecialization(request.getSpecialization());
        doctor.setExperience(request.getExperience());
        doctor.setConsultationFee(request.getConsultationFee());
        doctor.setAbout(request.getAbout());
        doctor.setCity(request.getCity());
        doctor.setHospital(request.getHospital());
        doctor.setUser(user);
        doctor.setAvailable(true);
        doctor.setRating(0.0);
        doctorRepository.save(doctor);

        response.setFullName(user.getFullName());
        response.setSpecialization(doctor.getSpecialization());
        response.setConsultationFee(doctor.getConsultationFee());
        return response;
    }

    public DoctorResponse getProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();
        Doctor doctor = doctorRepository.findByUser(user)
                        .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return DoctorResponse.builder()
                .fullName(user.getFullName())
                .specialization(doctor.getSpecialization())
                .city(doctor.getCity())
                .consultationFee(doctor.getConsultationFee())
                .build();
    }


}
