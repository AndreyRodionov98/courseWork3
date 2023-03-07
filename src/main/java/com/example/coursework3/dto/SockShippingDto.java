package com.example.coursework3.dto;

import com.example.coursework3.model.SocksSize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.awt.*;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class SockShippingDto {
        @NotNull(message = "цвет является обязательным ")
        private Color color;
        @NotNull(message = "размер является обязательным")
        private SocksSize size;
        @Range(min = 0, max = 100, message = "содержание хлопка от 0% до 100 %")
        private Integer cottonContent;
        @Positive(message = "количество является положительным числом")
        @Setter
        private int quantity;
    }

