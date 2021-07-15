package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Grado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-14T20:06:47")
@StaticMetamodel(NivelEducativo.class)
public class NivelEducativo_ { 

    public static volatile SingularAttribute<NivelEducativo, String> descripcion;
    public static volatile CollectionAttribute<NivelEducativo, Grado> gradoCollection;
    public static volatile SingularAttribute<NivelEducativo, Integer> id;

}