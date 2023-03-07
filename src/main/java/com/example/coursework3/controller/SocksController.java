package com.example.coursework3.controller;

import com.example.coursework3.dto.SockShippingDto;
import com.example.coursework3.model.SocksSize;
import com.example.coursework3.service.FileService;
import com.example.coursework3.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/socks")
@RequiredArgsConstructor
@Tag(name="склад носков",description = "CRUD-операции для работы с поставками носков")
public class SocksController {
private final SocksService sockService;
private final FileService sockFileService;
@PostMapping
    @Operation(summary = "добавление на склад носков")
    public void addSocks(@Valid @RequestBody SockShippingDto sockShippingDto){
    sockService.addSocks(sockShippingDto);
}
@PutMapping
    @Operation(summary = "отгрузка со склада")
public void sellSocks(@Valid @RequestBody SockShippingDto sockShippingDto){
    sockService.sellSocks(sockShippingDto);
}
@GetMapping
    @Operation(summary = "Получение носков по параметрам")
    public Integer getSocksCount(@RequestParam(required = false,name = "color") Color color,
                                 @RequestParam(required = false,name = "size") SocksSize size,
                                 @RequestParam(required = false,name = "cottonMin") Integer cottonMin,
                                 @RequestParam(required = false,name = "cottonMax") Integer cottonMax){
    return sockService.getSockQuantity(color,size,cottonMin,cottonMax);
    }
@DeleteMapping
    @Operation(summary="списание бракованных товаров")
    public void removeDefectiveSocks(@Valid @RequestBody SockShippingDto sockShippingDto){
    sockService.removeDefectiveSocks(sockShippingDto);
}
}
