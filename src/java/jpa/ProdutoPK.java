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
public class ProdutoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expositor_id")
    private int expositorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estande_id")
    private int estandeId;

    public ProdutoPK() {
    }

    public ProdutoPK(int id, int expositorId, int estandeId) {
        this.id = id;
        this.expositorId = expositorId;
        this.estandeId = estandeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpositorId() {
        return expositorId;
    }

    public void setExpositorId(int expositorId) {
        this.expositorId = expositorId;
    }

    public int getEstandeId() {
        return estandeId;
    }

    public void setEstandeId(int estandeId) {
        this.estandeId = estandeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) expositorId;
        hash += (int) estandeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoPK)) {
            return false;
        }
        ProdutoPK other = (ProdutoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.expositorId != other.expositorId) {
            return false;
        }
        if (this.estandeId != other.estandeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ProdutoPK[ id=" + id + ", expositorId=" + expositorId + ", estandeId=" + estandeId + " ]";
    }
    
}
