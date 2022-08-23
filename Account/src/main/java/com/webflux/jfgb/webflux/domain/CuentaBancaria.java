package com.webflux.jfgb.webflux.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("accountBank")
public class CuentaBancaria {
    @Id
    Integer idcuenta;
    String cnumero;
    Boolean bmovimiento; //Autorizado o no
    Boolean bcomision; //Si tiene o no tiene comision
    Date dfecreg;
    Integer ruc_dni; //Codigo del cliente
    String ctipcli; //Tipo cliente
    String ctipcue; //AH,CC,PF

    public Boolean getBmovimiento(){
        return this.bmovimiento;
    }

    public void setBmovimiento(Boolean bmovimiento){
        this.bmovimiento = bmovimiento;
    }

    public Boolean getBcomision(){
        return this.bcomision;
    }

    public void setBcomision(Boolean bcomision){
        this.bcomision = bcomision;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append("{\"idcuenta\":")
                .append(getIdcuenta())
                .append(",\"cnumero\":")
                .append(getCnumero())
                .append("{\"bmovimiento\":")
                .append(getBmovimiento())
                .append("{\"bcomision\":")
                .append(getBcomision())
                .append("{\"dfecreg\":")
                .append(getDfecreg())
                .append("{\"ruc_dni\":")
                .append(getRuc_dni())
                .append("{\"ctipcli\":")
                .append(getCtipcli())
                .append("{\"ctipcue\":")
                .append(getCtipcue())
                .append("}")
                .toString();
    }
}