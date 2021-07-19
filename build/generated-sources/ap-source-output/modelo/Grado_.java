package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.NivelEducativo;
import modelo.Seccion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-19T12:35:43")
@StaticMetamodel(Grado.class)
public class Grado_ { 

    public static volatile SingularAttribute<Grado, Integer> grado;
    public static volatile SingularAttribute<Grado, Integer> id;
    public static volatile SingularAttribute<Grado, NivelEducativo> nivel;
    public static volatile CollectionAttribute<Grado, Seccion> seccionCollection;

}