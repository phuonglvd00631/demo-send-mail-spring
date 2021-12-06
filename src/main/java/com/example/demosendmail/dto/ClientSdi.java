package com.example.demosendmail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSdi {
    private String name;
    private String username; // name va username de test data fill ben ngoai template email
    private String[] email; // danh sach dia chi email de gui
}
