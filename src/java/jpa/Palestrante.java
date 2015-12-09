/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "palestrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestrante.findAll", query = "SELECT p FROM Palestrante p"),
    @NamedQuery(name = "Palestrante.findById", query = "SELECT p FROM Palestrante p WHERE p.id = :id"),
    @NamedQuery(name = "Palestrante.findByCpf", query = "SELECT p FROM Palestrante p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Palestrante.findByContaBanco", query = "SELECT p FROM Palestrante p WHERE p.contaBanco = :contaBanco"),
    @NamedQuery(name = "Palestrante.findByAgenciaBanco", query = "SELECT p FROM Palestrante p WHERE p.agenciaBanco = :agenciaBanco"),
    @NamedQuery(name = "Palestrante.findByNomeBanco", query = "SELECT p FROM Palestrante p WHERE p.nomeBanco = :nomeBanco"),
    @NamedQuery(name = "Palestrante.findByNome", query = "SELECT p FROM Palestrante p WHERE p.nome = :nome"),
    @NamedQuery(name = "Palestrante.findByEmail", query = "SELECT p FROM Palestrante p WHERE p.email = :email"),
    @NamedQuery(name = "Palestrante.findByTelefone", query = "SELECT p FROM Palestrante p WHERE p.telefone = :telefone")})
public class Palestrante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 45)
    @Column(name = "conta_banco")
    private String contaBanco;
    @Size(max = 45)
    @Column(name = "agencia_banco")
    private String agenciaBanco;
    @Size(max = 45)
    @Column(name = "nome_banco")
    private String nomeBanco;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "palestrante")
    private Collection<Palestra> palestraCollection;

    public Palestrante() {
    }

    public Palestrante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContaBanco() {
        return contaBanco;
    }

    public void setContaBanco(String contaBanco) {
        this.contaBanco = contaBanco;
    }

    public String getAgenciaBanco() {
        return agenciaBanco;
    }

    public void setAgenciaBanco(String agenciaBanco) {
        this.agenciaBanco = agenciaBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public Collection<Palestra> getPalestraCollection() {
        return palestraCollection;
    }

    public void setPalestraCollection(Collection<Palestra> palestraCollection) {
        this.palestraCollection = palestraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestrante)) {
            return false;
        }
        Palestrante other = (Palestrante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
