package com.example.coursework3.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.awt.*;
@Data
@Builder
@EqualsAndHashCode
@ToString
public class Sock {
    private Color color;
    private SocksSize size;
    public int cottonContent;
}
