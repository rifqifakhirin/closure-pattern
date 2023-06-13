package com.example.automatedgeneration.service;

import com.example.automatedgeneration.dto.ManualOneRequestDto;
import com.example.automatedgeneration.entity.ManualOne;
import com.example.automatedgeneration.repository.ManualOneRepository;
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
