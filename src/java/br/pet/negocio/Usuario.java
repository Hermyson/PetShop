package br.pet.negocio;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USUARIO")
@ManagedBean (name = "usuarioClass")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CODIGO")
    private long codigo;
    @Column (name = "PERFIL", length = 50)
    private String perfil;
    @Column (name = "USUARIO", length = 10)
    private String userNome;
    @Column (name = "SENHA", length = 10)
    private String userSenha;

    //Método construtor
    public Usuario() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }
    
    

}
