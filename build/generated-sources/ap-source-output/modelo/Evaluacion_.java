package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.SeccionCurso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-18T10:47:21")
@StaticMetamodel(Evaluacion.class)
public class Evaluacion_ { 

    public static volatile SingularAttribute<Evaluacion, String> descripcion;
    public static volatile SingularAttribute<Evaluacion, Boolean> bonus;
    public static volatile SingularAttribute<Evaluacion, SeccionCurso> seccionCurso;
    public static volatile SingularAttribute<Evaluacion, Integer> id;
    public static volatile SingularAttribute<Evaluacion, Integer> porcentaje;

}