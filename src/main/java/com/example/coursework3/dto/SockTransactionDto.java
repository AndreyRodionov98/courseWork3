package com.example.coursework3.dto;

import com.example.coursework3.model.OperationType;
import com.example.coursework3.model.SocksSize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.awt.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SockTransactionDto {
    @NotNull(message ="цвет является обязательным ")
    private Color color;
    @NotNull(message = "размер является обязательным")
    private SocksSize sockSize;
    @Range(min = 0,max = 100,message = "содержание хлопка от 0% до 100 %")
    private Integer cottonContent;
    @Positive(message = "количество является положительным числом")
    @Setter
    private int quantity;
    @JsonSerialize(using = LocalDateSerializer.class )
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;
    private OperationType operationType;

}
