/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Jhonatan
 */
@Entity
@Table(name = "nivel_educativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEducativo.findAll", query = "SELECT n FROM NivelEducativo n")
    , @NamedQuery(name = "NivelEducativo.findById", query = "SELECT n FROM NivelEducativo n WHERE n.id = :id")
    , @NamedQuery(name = "NivelEducativo.findByDescripcion", query = "SELECT n FROM NivelEducativo n WHERE n.descripcion = :descripcion")})
public class NivelEducativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel")
    private Collection<Grado> gradoCollection;

    public NivelEducativo() {
    }

    public NivelEducativo(Integer id) {
        this.id = id;
    }

    public NivelEducativo(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Grado> getGradoCollection() {
        return gradoCollection;
    }

    public void setGradoCollection(Collection<Grado> gradoCollection) {
        this.gradoCollection = gradoCollection;
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
        if (!(object instanceof NivelEducativo)) {
            return false;
        }
        NivelEducativo other = (NivelEducativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.NivelEducativo[ id=" + id + " ]";
    }
    
}
