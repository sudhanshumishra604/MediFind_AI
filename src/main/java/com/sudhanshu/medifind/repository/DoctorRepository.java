package com.sudhanshu.medifind.repository;
                                                                       // Repository talks to the database
import com.sudhanshu.medifind.entity.Doctor;                           // It provide method to deal with different datavase
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}