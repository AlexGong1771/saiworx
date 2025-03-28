package com.example.saiworx.service;

import com.example.saiworx.entity.Component;
import com.example.saiworx.entity.ComponentType;
import com.example.saiworx.repository.ComponentRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComponentService {

    private final ComponentRepository repository;

    public ComponentService(ComponentRepository repository) {
        this.repository = repository;
    }

    public Component createComponent(Component component) {
        if (component.getName().length() > 40) {
            throw new ValidationException("name musi mat dlzku max 40 znakov.");
        }

        if (component.getType() == null) {
            component.setType(ComponentType.INVALID);
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
