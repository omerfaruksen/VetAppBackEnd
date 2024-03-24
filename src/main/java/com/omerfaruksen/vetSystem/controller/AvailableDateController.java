package com.omerfaruksen.vetSystem.controller;


import com.omerfaruksen.vetSystem.dto.request.AvailableDateRequestDto;
import com.omerfaruksen.vetSystem.entity.AvailableDate;
import com.omerfaruksen.vetSystem.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    public final AvailableDateService availableDateService;

    @GetMapping
    public List<AvailableDate> findAllAvailableDates (){
        return availableDateService.findAllAvailableDates();
    }

    @GetMapping("/{id}")
    public AvailableDate findAvailableDateById (@PathVariable Long id){
        return availableDateService.findAvailableDateById(id);
    }

    @PostMapping
    public AvailableDate createAvailableDate (@RequestBody AvailableDateRequestDto availableDateRequestDto){
        return availableDateService.createAvailableDate(availableDateRequestDto);
    }

    @PutMapping("/{id}")
    public AvailableDate updateAvailableDate (@PathVariable Long id, @RequestBody AvailableDateRequestDto availableDateRequestDto){
        return availableDateService.updateAvailableDate(id,availableDateRequestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteAvailableDate(@PathVariable Long id){
        return availableDateService.deleteAvailableDate(id);
    }
}