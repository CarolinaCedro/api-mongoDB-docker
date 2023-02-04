package io.CarolinaCedro.apimongoDB.aplication.dto.request;

import io.CarolinaCedro.apimongoDB.model.Adm;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String id;
    private String name;
    private String lastname;
    private String phone;
    private String age;
    private Adm adm;

    public UserRequestDto(String name, String lastname, String phone, String age, Adm adm) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.age = age;
        this.adm = adm;
    }
}
