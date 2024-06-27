package br.pet.negocio;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Hermyson
 *
 */
@Entity
@Table(name = "Animal")
@ManagedBean(name = "animal")
public class Animal implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "codigo_Animal")
    private int codigo_Animal;
    @Column(length = 50, name = "nome_Animal")
    private String nome_Animal;
    @Column(length = 50, name = "tipo")
    private String tipo;
//    @Column(length = 200, name = "descricao")
//    private String descricao;
    @Column(name = "dt_Nascimento", length = 20)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtNascimento;
    @Column(length = 20, name = "raca")
    private String raca;
    @Column(length = 10, name = "sexo")
    private String sexo;
    @Column(length = 255, name = "observacao")
    private String observacao;

    public Animal() {
    }

    public int getCodigo_Animal() {
        return codigo_Animal;
    }

    public void setCodigo_Animal(int codigo_Animal) {
        this.codigo_Animal = codigo_Animal;
    }

    public String getNome_Animal() {
        return nome_Animal;
    }

    public void setNome_Animal(String nome_Animal) {
        this.nome_Animal = nome_Animal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
