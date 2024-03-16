package com.omerfaruksen.vetSystem.dto.request;


import com.omerfaruksen.vetSystem.entity.Animal;
import com.omerfaruksen.vetSystem.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDto {

    private LocalDateTime date;
    private Doctor doctor;
    private Animal animal;
}