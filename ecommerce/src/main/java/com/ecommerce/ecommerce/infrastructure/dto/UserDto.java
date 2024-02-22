package com.ecommerce.ecommerce.infrastructure.dto;

import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {


    private String username;
    @NotBlank(message = "Nombre requerido")
    private String firstName;
    @NotBlank(message = "Apellido requerido")
    private String lastName;
    @Email(message = "Ingresar un email valido")
    private String email;
    @NotBlank(message = "Direccion requerido")
    private String address;
    @NotBlank(message = "Celular requerido")
    private String cellphone;
    @NotBlank(message = "Contraseña requerido")
    private String password;

    public User userDtoToUser(){
        return new User(null,this.getEmail(),this.firstName,this.getLastName(),this.getEmail(),this.getAddress(),this.getCellphone(),this.cellphone, UserType.USER, LocalDateTime.now());
    }
}
