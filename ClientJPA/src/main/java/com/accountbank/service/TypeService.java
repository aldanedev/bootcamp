package com.accountbank.service;


import com.accountbank.model.Type;

import java.util.List;

public interface TypeService {
    void init();
    List<Type> create(Type type);

    List<Type> getTypes();
}
