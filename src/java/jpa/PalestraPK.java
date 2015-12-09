/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eric
 */
@Embeddable
public class PalestraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "palestrante_id")
    private int palestranteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "palco_id")
    private int palcoId;

    public PalestraPK() {
    }

    public PalestraPK(int id, int palestranteId, int palcoId) {
        this.id = id;
        this.palestranteId = palestranteId;
        this.palcoId = palcoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPalestranteId() {
        return palestranteId;
    }

    public void setPalestranteId(int palestranteId) {
        this.palestranteId = palestranteId;
    }

    public int getPalcoId() {
        return palcoId;
    }

    public void setPalcoId(int palcoId) {
        this.palcoId = palcoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) palestranteId;
        hash += (int) palcoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PalestraPK)) {
            return false;
        }
        PalestraPK other = (PalestraPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.palestranteId != other.palestranteId) {
            return false;
        }
        if (this.palcoId != other.palcoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.PalestraPK[ id=" + id + ", palestranteId=" + palestranteId + ", palcoId=" + palcoId + " ]";
    }
    
}
