package com.webflux.jfgb.webflux.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("account")
public class Cuenta {

    @Id
    String id;
    String name;

    @Override
    public String toString (){
        return new StringBuilder()
                .append("{\"id\":")
                .append(getId())
                .append(",\"name\":")
                .append(getName())
                .append("}")
                .toString();
    }
}
