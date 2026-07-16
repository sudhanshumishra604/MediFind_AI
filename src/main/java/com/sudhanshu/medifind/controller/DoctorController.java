package com.sudhanshu.medifind.controller;

import com.sudhanshu.medifind.dto.request.DoctorRegisterRequest;
import com.sudhanshu.medifind.dto.response.DoctorResponse;
import com.sudhanshu.medifind.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                           // RestController->  This class handles HTTP requests and returns JSON responses
@RequestMapping("/api/doctors")                                      // Spring automatically registers this class as a controller.
//The controller is the entry point of your application.
public class DoctorController {                                      //The controller's responsibilities are:
   private final DoctorService doctorService;                        // Receive the request

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;                           //Validate basic input   //Call the service
    }                                                                  //  Return the response

    @PostMapping("/register")
    public ResponseEntity<DoctorResponse> registerDoctor(
            @RequestBody DoctorRegisterRequest request) {

        DoctorResponse response = doctorService.registerDoctor(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<DoctorResponse> getProfile(){
        return ResponseEntity.ok(doctorService.getProfile());
    }
}
