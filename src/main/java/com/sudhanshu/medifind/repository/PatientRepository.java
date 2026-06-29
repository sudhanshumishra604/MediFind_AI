package com.sudhanshu.medifind.repository;

import com.sudhanshu.medifind.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}