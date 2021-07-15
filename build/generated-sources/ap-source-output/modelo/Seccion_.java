package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.AlumnoSeccion;
import modelo.Grado;
import modelo.SeccionCurso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-14T20:06:47")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, String> descripcion;
    public static volatile SingularAttribute<Seccion, Grado> grado;
    public static volatile CollectionAttribute<Seccion, SeccionCurso> seccionCursoCollection;
    public static volatile SingularAttribute<Seccion, Integer> id;
    public static volatile CollectionAttribute<Seccion, AlumnoSeccion> alumnoSeccionCollection;
    public static volatile SingularAttribute<Seccion, Integer> anio;

}