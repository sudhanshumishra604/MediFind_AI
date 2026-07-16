package com.sudhanshu.medifind.repository;
                                                                       // Repository talks to the database
import com.sudhanshu.medifind.entity.Doctor;                           // It provide method to deal with different datavase
import com.sudhanshu.medifind.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByUser(User user);

}