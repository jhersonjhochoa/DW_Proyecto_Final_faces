package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Curso;
import modelo.Evaluacion;
import modelo.Seccion;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-14T20:06:47")
@StaticMetamodel(SeccionCurso.class)
public class SeccionCurso_ { 

    public static volatile SingularAttribute<SeccionCurso, Seccion> seccion;
    public static volatile SingularAttribute<SeccionCurso, Curso> curso;
    public static volatile SingularAttribute<SeccionCurso, Usuario> docente;
    public static volatile SingularAttribute<SeccionCurso, Integer> id;
    public static volatile CollectionAttribute<SeccionCurso, Evaluacion> evaluacionCollection;

}