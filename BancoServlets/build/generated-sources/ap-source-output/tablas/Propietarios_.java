package tablas;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tablas.Cuentasbancarias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-18T05:24:15")
@StaticMetamodel(Propietarios.class)
public class Propietarios_ { 

    public static volatile CollectionAttribute<Propietarios, Cuentasbancarias> cuentasbancariasCollection;
    public static volatile SingularAttribute<Propietarios, String> primerApellido;
    public static volatile SingularAttribute<Propietarios, String> segundoApellido;
    public static volatile SingularAttribute<Propietarios, String> numeroSecreto;
    public static volatile SingularAttribute<Propietarios, String> usuario;
    public static volatile SingularAttribute<Propietarios, String> nombre;
    public static volatile SingularAttribute<Propietarios, String> dni;

}