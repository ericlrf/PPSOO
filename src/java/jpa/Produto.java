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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.produtoPK.id = :id"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco"),
    @NamedQuery(name = "Produto.findByCategoria", query = "SELECT p FROM Produto p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Produto.findByInformacoes", query = "SELECT p FROM Produto p WHERE p.informacoes = :informacoes"),
    @NamedQuery(name = "Produto.findByExpositorId", query = "SELECT p FROM Produto p WHERE p.produtoPK.expositorId = :expositorId"),
    @NamedQuery(name = "Produto.findByEstandeId", query = "SELECT p FROM Produto p WHERE p.produtoPK.estandeId = :estandeId")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoPK produtoPK;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;
    @Size(max = 45)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 245)
    @Column(name = "informacoes")
    private String informacoes;
    @JoinColumn(name = "expositor_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Expositor expositor;
    @JoinColumn(name = "estande_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estande estande;

    public Produto() {
    }

    public Produto(ProdutoPK produtoPK) {
        this.produtoPK = produtoPK;
    }

    public Produto(int id, int expositorId, int estandeId) {
        this.produtoPK = new ProdutoPK(id, expositorId, estandeId);
    }

    public ProdutoPK getProdutoPK() {
        return produtoPK;
    }

    public void setProdutoPK(ProdutoPK produtoPK) {
        this.produtoPK = produtoPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    public Estande getEstande() {
        return estande;
    }

    public void setEstande(Estande estande) {
        this.estande = estande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoPK != null ? produtoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.produtoPK == null && other.produtoPK != null) || (this.produtoPK != null && !this.produtoPK.equals(other.produtoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Produto[ produtoPK=" + produtoPK + " ]";
    }
    
}
