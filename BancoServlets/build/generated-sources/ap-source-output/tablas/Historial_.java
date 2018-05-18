package tablas;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tablas.Cuentasbancarias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-18T05:24:15")
@StaticMetamodel(Historial.class)
public class Historial_ { 

    public static volatile SingularAttribute<Historial, String> tipoEvento;
    public static volatile SingularAttribute<Historial, Date> fechaHora;
    public static volatile SingularAttribute<Historial, Cuentasbancarias> numeroCuenta;
    public static volatile SingularAttribute<Historial, Integer> idHistorico;

}