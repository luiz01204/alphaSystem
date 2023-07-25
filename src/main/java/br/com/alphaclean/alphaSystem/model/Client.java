package br.com.alphaclean.alphaSystem.model;

import br.com.alphaclean.alphaSystem.dto.DataClient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private String street;
    private String number;
    private String district;
    private String city;
    private String uf;
    private String cep;

    public Client(DataClient data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.email = data.email();
        this.phone = data.phone();
        this.street = data.street();
        this.number = data.number();
        this.district = data.district();
        this.city = data.city();
        this.uf = data.uf();
        this.cep = data.cep();
    }

    public void editData(DataClient data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.email = data.email();
        this.phone = data.phone();
        this.street = data.street();
        this.number = data.number();
        this.district = data.district();
        this.city = data.city();
        this.uf = data.uf();
        this.cep = data.cep();
    }
}
