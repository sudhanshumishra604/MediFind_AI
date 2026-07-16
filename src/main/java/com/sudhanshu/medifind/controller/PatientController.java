package com.sudhanshu.medifind.controller;

import com.sudhanshu.medifind.dto.request.PatientRegisterRequest;
import com.sudhanshu.medifind.dto.response.PatientResponse;
import com.sudhanshu.medifind.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> registerPatient(@RequestBody PatientRegisterRequest request){
        PatientResponse response = patientService.registerPatient(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<PatientResponse> getProfile(){
        return ResponseEntity.ok(patientService.getProfile());
    }
}
