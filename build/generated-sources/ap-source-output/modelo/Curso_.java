package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.SeccionCurso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-19T12:35:43")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile CollectionAttribute<Curso, SeccionCurso> seccionCursoCollection;
    public static volatile SingularAttribute<Curso, Integer> id;
    public static volatile SingularAttribute<Curso, String> nombre;

}