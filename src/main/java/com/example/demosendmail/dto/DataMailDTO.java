package com.example.demosendmail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataMailDTO {
    private String[] to; // danh sach email dc truyen  clientSdi
    private String subject;
    private String content;
    private Map<String, Object> props; // thuoc tinh de mapping data sang cho template
}
