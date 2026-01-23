package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.PlaceDto;
import com.mkahn.mkahn.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/list")
    public List<PlaceDto> list() {
        return placeService.list();
    }

    @PostMapping
    public PlaceDto save(@RequestBody PlaceDto dto) {
        return placeService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        placeService.delete(id);
    }
}