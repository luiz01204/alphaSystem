package br.com.alphaclean.alphaSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataClient(
        @NotBlank(message = "Este campo não deve estar em branco!")
        String name,
        @NotBlank(message = "Este campo não deve estar em branco!")
        @Pattern(regexp ="\\d{11}", message = "CPF deve ter 11 digitos!")
        String cpf,
        @NotBlank(message = "Este campo não deve estar em branco!")
        @Email
        String email,
        @NotBlank(message = "Este campo não deve estar em branco!")
        @Pattern(regexp ="\\d{0,20}", message = "Não pode passar de 20 digitos!")
        String phone,
        @NotBlank(message = "Este campo não pode estar em banco!")
        String street,
        @NotBlank(message = "Este campo não pode estar em banco!")
        String number,
        @NotBlank(message = "Este campo não pode estar em banco!")
        String district,
        @NotBlank(message = "Este campo não pode estar em banco!")
        String city,
        @NotBlank(message = "Este campo não pode estar em banco!")
        String uf,
        @NotBlank(message = "Este campo não pode estar em banco!")
        @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 digitos!")
        String cep
) {
}
