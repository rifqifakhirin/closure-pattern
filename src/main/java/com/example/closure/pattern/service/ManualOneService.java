package com.example.closure.pattern.service;

import com.example.closure.pattern.dto.ManualOneRequestDto;
import com.example.closure.pattern.entity.ManualOne;
import com.example.closure.pattern.repository.ManualOneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManualOneService {

    private final ManualOneRepository manualOneRepository;

    public ManualOne createManualOne(ManualOneRequestDto manualOneRequestDto) {
        return manualOneRepository.save(
                ManualOne.builder()
                        .price(manualOneRequestDto.getPrice())
                        .name(manualOneRequestDto.getName())
                        .iso(manualOneRequestDto.getIso())
                        .build()
        );
    }
}
