package com.webflux.jfgb.webflux.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("accountMovement")
public class CuentaMovimiento {

    @Id
    Integer idcuentamov;
    Integer nmovimiento; // cantidad de movimientos como maximo (0 o mas)
    Integer ncomision;
    Boolean btipomov; //Retiro(true) o Deposito(false)
    Integer idcuenta; //ID de la cuenta bancaria (AccountBank)
    Date dfecmov;
    Double nsaldo;

    @Override
    public String toString(){
        return new StringBuilder()
                .append("{\"idcuentamov\":")
                .append(getIdcuentamov())
                .append("{\"nmovimiento\":")
                .append(getNmovimiento())
                .append("{\"ncomision\":")
                .append(getNcomision())
                .append("{\"btipomov\":")
                .append(getBtipomov())
                .append("{\"idcuenta\":")
                .append(getIdcuenta())
                .append("{\"dfecmov\":")
                .append(getDfecmov())
                .append("{\"nsaldo\":")
                .append(getNsaldo())
                .append("}")
                .toString();
    }
}
