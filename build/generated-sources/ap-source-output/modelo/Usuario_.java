package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.AlumnoSeccion;
import modelo.RolUsuario;
import modelo.SeccionCurso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-19T12:35:43")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile CollectionAttribute<Usuario, SeccionCurso> seccionCursoCollection;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> documento;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile CollectionAttribute<Usuario, AlumnoSeccion> alumnoSeccionCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> user;
    public static volatile SingularAttribute<Usuario, RolUsuario> rol;

}