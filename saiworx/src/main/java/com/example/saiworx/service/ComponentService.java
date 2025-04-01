package com.example.saiworx.service;

import com.example.saiworx.entity.Component;
import com.example.saiworx.entity.ComponentType;
import com.example.saiworx.repository.ComponentRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComponentService {

    private final ComponentRepository repository;

    public ComponentService(ComponentRepository repository) {
        this.repository = repository;
    }

    public Component createComponent(Component component ) {
        if (component.getName() == null || component.getName().length() > 40) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(411),"name musi byt nie null a do 40 znakov");
        }

        if (component.getType() == null ) {

            component.setType(ComponentType.INVALID);
        }



        if (component.getId() != null && repository.existsById(component.getId())) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(409),"Component  s ID uz existuje");
        }
        if (component.getId() == null){
          component.setId(UUID.randomUUID());
        }

        if (component.getCreatedAt() != null && component.getCreatedAt().after(new Date())) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(409),"datum je v buducnosti");
        }


        if (component.getCreatedAt() == null) {
            component.setCreatedAt(new Date());
        }

        return repository.save(component);
    }




    public List<Component> getAllComponents() {
        return repository.findAll();
    }

    public Optional<Component> getComponentById(UUID id) {
        return repository.findById(id);
    }

    public boolean deleteComponent(UUID id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
