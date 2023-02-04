package io.CarolinaCedro.apimongoDB.aplication.dto.response;

import io.CarolinaCedro.apimongoDB.model.Adm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String id;
    private String name;
    private String lastname;
    private String phone;
    private String age;
    private Adm adm;
}
