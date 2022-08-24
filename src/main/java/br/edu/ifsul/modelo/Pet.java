/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20202PF.CC0011
 */
@Entity
@Table(name = "pet")
public class Pet implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
    private Integer id;
     
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de nascimento deve ser informada")	
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @Column(name = "peso", nullable = false, columnDefinition = "NUMERIC(10,2)")
    private Double peso;
    
    @NotBlank(message = "A espécie deve ser informada")
    @Length(max = 40, message = "A espécie não pode ter mais de {max} caracteres")
    @Column(name = "especie", nullable = false, length = 40)
    private String especie;
    
    public Pet(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
