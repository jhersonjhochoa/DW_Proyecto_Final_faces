/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")
    , @NamedQuery(name = "Seccion.findById", query = "SELECT s FROM Seccion s WHERE s.id = :id")
    , @NamedQuery(name = "Seccion.findByDescripcion", query = "SELECT s FROM Seccion s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Seccion.findByAnio", query = "SELECT s FROM Seccion s WHERE s.anio = :anio")})
public class Seccion implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @JoinColumn(name = "grado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grado grado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccion")
    private Collection<SeccionCurso> seccionCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccion")
    private Collection<AlumnoSeccion> alumnoSeccionCollection;

    public Seccion() {
        anio = Calendar.getInstance().get(Calendar.YEAR);
    }

    public Seccion(Integer id) {
        this.id = id;
    }

    public Seccion(Integer id, String descripcion, int anio) {
        this.id = id;
        this.descripcion = descripcion;
        this.anio = anio;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    @XmlTransient
    public Collection<SeccionCurso> getSeccionCursoCollection() {
        return seccionCursoCollection;
    }

    public void setSeccionCursoCollection(Collection<SeccionCurso> seccionCursoCollection) {
        this.seccionCursoCollection = seccionCursoCollection;
    }

    @XmlTransient
    public Collection<AlumnoSeccion> getAlumnoSeccionCollection() {
        return alumnoSeccionCollection;
    }

    public void setAlumnoSeccionCollection(Collection<AlumnoSeccion> alumnoSeccionCollection) {
        this.alumnoSeccionCollection = alumnoSeccionCollection;
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
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Seccion[ id=" + id + " ]";
    }
    
}
