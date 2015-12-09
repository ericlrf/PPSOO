/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "palestra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestra.findAll", query = "SELECT p FROM Palestra p"),
    @NamedQuery(name = "Palestra.findById", query = "SELECT p FROM Palestra p WHERE p.palestraPK.id = :id"),
    @NamedQuery(name = "Palestra.findByNome", query = "SELECT p FROM Palestra p WHERE p.nome = :nome"),
    @NamedQuery(name = "Palestra.findByPreco", query = "SELECT p FROM Palestra p WHERE p.preco = :preco"),
    @NamedQuery(name = "Palestra.findByInformacoes", query = "SELECT p FROM Palestra p WHERE p.informacoes = :informacoes"),
    @NamedQuery(name = "Palestra.findByPalestranteId", query = "SELECT p FROM Palestra p WHERE p.palestraPK.palestranteId = :palestranteId"),
    @NamedQuery(name = "Palestra.findByPalcoId", query = "SELECT p FROM Palestra p WHERE p.palestraPK.palcoId = :palcoId")})
public class Palestra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PalestraPK palestraPK;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "preco")
    private String preco;
    @Size(max = 245)
    @Column(name = "informacoes")
    private String informacoes;
    @JoinColumn(name = "palestrante_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Palestrante palestrante;
    @JoinColumn(name = "palco_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Palco palco;

    public Palestra() {
    }

    public Palestra(PalestraPK palestraPK) {
        this.palestraPK = palestraPK;
    }

    public Palestra(int id, int palestranteId, int palcoId) {
        this.palestraPK = new PalestraPK(id, palestranteId, palcoId);
    }

    public PalestraPK getPalestraPK() {
        return palestraPK;
    }

    public void setPalestraPK(PalestraPK palestraPK) {
        this.palestraPK = palestraPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public Palco getPalco() {
        return palco;
    }

    public void setPalco(Palco palco) {
        this.palco = palco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (palestraPK != null ? palestraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestra)) {
            return false;
        }
        Palestra other = (Palestra) object;
        if ((this.palestraPK == null && other.palestraPK != null) || (this.palestraPK != null && !this.palestraPK.equals(other.palestraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Palestra[ palestraPK=" + palestraPK + " ]";
    }
    
}
