package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Seccion;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-14T20:06:47")
@StaticMetamodel(AlumnoSeccion.class)
public class AlumnoSeccion_ { 

    public static volatile SingularAttribute<AlumnoSeccion, Seccion> seccion;
    public static volatile SingularAttribute<AlumnoSeccion, BigDecimal> promedio;
    public static volatile SingularAttribute<AlumnoSeccion, Usuario> alumno;
    public static volatile SingularAttribute<AlumnoSeccion, Integer> id;
    public static volatile SingularAttribute<AlumnoSeccion, Integer> ordenMertio;

}