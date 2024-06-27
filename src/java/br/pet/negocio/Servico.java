package br.pet.negocio;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Hermyson
 */
@Entity
@Table(name = "Servico")
@ManagedBean(name = "servico")
public class Servico implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "codigo_servico")
    private int codigo;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "animal_id")
//    private Animal animal;

    @Column(name = "descricao", length = 200)
    private String Descricao;
    @Column(name = "valor", length = 20)
    private double Valor;
    @Column(name = "tipo_Servico", length = 20)
    private String tipo_Servico;

    public String getTipo_Servico() {
        return tipo_Servico;
    }

    public void setTipo_Servico(String tipo_Servico) {
        this.tipo_Servico = tipo_Servico;
    }
   
    @Column(name = "data_servico")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_Servico;
    @Column(length = 200, name = "observacao")
    private String Observacao;
    
    @Column(name = "pagamento",length = 10 )
    private String pagamento;

    //Método construtorl
    public Servico() {

    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData_Servico() {
        return data_Servico;
    }

    public void setData_Servico(Date data_Servico) {
        this.data_Servico = data_Servico;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

  
//    public Animal getAnimal() {
//        return animal;
//    }
//
//    public void setAnimal(Animal animal) {
//        this.animal = animal;
//    }

}
