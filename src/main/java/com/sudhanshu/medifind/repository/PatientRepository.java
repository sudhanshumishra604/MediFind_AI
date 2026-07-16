package com.sudhanshu.medifind.repository;

import com.sudhanshu.medifind.entity.Patient;
import com.sudhanshu.medifind.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUser(User user);
}