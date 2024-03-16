package com.omerfaruksen.vetSystem.controller;


import com.omerfaruksen.vetSystem.dto.request.DoctorRequestDto;
import com.omerfaruksen.vetSystem.entity.Doctor;
import com.omerfaruksen.vetSystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    public final DoctorService doctorService;

    @GetMapping
    public List<Doctor> findAllDoctors (){
        return doctorService.findAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor findDoctorById (@PathVariable Long id){
        return doctorService.findDoctorById(id);
    }

    @PostMapping
    public Doctor createDoctor (@RequestBody DoctorRequestDto doctorRequestDto){
        return doctorService.createDoctor(doctorRequestDto);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor (@PathVariable Long id, @RequestBody DoctorRequestDto doctorRequestDto){
        return doctorService.updateDoctor(id,doctorRequestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id){
        return doctorService.deleteDoctor(id);
    }
}