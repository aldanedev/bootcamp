package com.accountbank.service.impl;

import com.accountbank.model.Type;
import com.accountbank.repository.ClientRepository;
import com.accountbank.repository.TypeRepository;
import com.accountbank.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeRepository typeRepository;

    @Override
    @PostConstruct
    public void init() {
        if(getTypes().isEmpty()){
            Type per = new Type();
            per.setDescription("Personal");
            create(per);

            Type emp = new Type();
            emp.setDescription("Empresarial");
            create(emp);
        }
    }

    @Override
    public List<Type> create(Type type) {
        return List.of(typeRepository.save(type));
    }

    @Override
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

}
