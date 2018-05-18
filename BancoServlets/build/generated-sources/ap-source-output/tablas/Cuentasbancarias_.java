package tablas;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tablas.Historial;
import tablas.Propietarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-18T05:24:15")
@StaticMetamodel(Cuentasbancarias.class)
public class Cuentasbancarias_ { 

    public static volatile CollectionAttribute<Cuentasbancarias, Historial> historialCollection;
    public static volatile SingularAttribute<Cuentasbancarias, Propietarios> propietario;
    public static volatile SingularAttribute<Cuentasbancarias, String> numeroCuenta;
    public static volatile SingularAttribute<Cuentasbancarias, Double> saldo;

}