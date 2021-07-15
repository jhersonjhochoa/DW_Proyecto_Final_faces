/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonatan
 */
@Entity
@Table(name = "alumno_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoSeccion.findAll", query = "SELECT a FROM AlumnoSeccion a")
    , @NamedQuery(name = "AlumnoSeccion.findById", query = "SELECT a FROM AlumnoSeccion a WHERE a.id = :id")
    , @NamedQuery(name = "AlumnoSeccion.findByPromedio", query = "SELECT a FROM AlumnoSeccion a WHERE a.promedio = :promedio")
    , @NamedQuery(name = "AlumnoSeccion.findByOrdenMertio", query = "SELECT a FROM AlumnoSeccion a WHERE a.ordenMertio = :ordenMertio")})
public class AlumnoSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "promedio")
    private BigDecimal promedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden_mertio")
    private int ordenMertio;
    @JoinColumn(name = "alumno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario alumno;
    @JoinColumn(name = "seccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Seccion seccion;

    public AlumnoSeccion() {
    }

    public AlumnoSeccion(Integer id) {
        this.id = id;
    }

    public AlumnoSeccion(Integer id, BigDecimal promedio, int ordenMertio) {
        this.id = id;
        this.promedio = promedio;
        this.ordenMertio = ordenMertio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public int getOrdenMertio() {
        return ordenMertio;
    }

    public void setOrdenMertio(int ordenMertio) {
        this.ordenMertio = ordenMertio;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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
        if (!(object instanceof AlumnoSeccion)) {
            return false;
        }
        AlumnoSeccion other = (AlumnoSeccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AlumnoSeccion[ id=" + id + " ]";
    }
    
}
