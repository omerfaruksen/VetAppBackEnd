package com.omerfaruksen.vetSystem.dto.request;


import com.omerfaruksen.vetSystem.entity.Animal;
import com.omerfaruksen.vetSystem.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineRequestDto {
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;
    private Animal animal;
    private Report report;
}