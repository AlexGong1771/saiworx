package com.example.saiworx.repository;

import com.example.saiworx.entity.Component;
import com.example.saiworx.entity.ComponentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@Transactional
public class ComponentRepositoryTest {

    @Autowired
    private ComponentRepository componentRepository;

    private Component component;

    @BeforeEach
    public void setUp() {
        // Priprava komponenta
        component = new Component();
        component.setName("Component A");
        component.setType(ComponentType.GEAR);
    }

    @Test
    public void testCreateComponent() {
       // Uloz komponent
        Component savedComponent = componentRepository.save(component);

        // Kontrola ci je ulozeny
        assertNotNull(savedComponent.getId());
        assertEquals("Component A", savedComponent.getName());
        assertEquals(ComponentType.GEAR, savedComponent.getType());
    }

    @Test
    public void testFindComponentById() {
        // Uloz komponent
        Component savedComponent = componentRepository.save(component);

        // Najdi ho
        Optional<Component> foundComponent = componentRepository.findById(savedComponent.getId());

        // Kontrola ci bol najdeny
        assertTrue(foundComponent.isPresent());
        assertEquals(savedComponent.getId(), foundComponent.get().getId());
    }

    @Test
    public void testDeleteComponent() {
        // Uloz komponent
        Component savedComponent = componentRepository.save(component);

        // Vymaz komponent
        componentRepository.deleteById(savedComponent.getId());

        // Kontrola ze sme ho deletovali
        Optional<Component> foundComponent = componentRepository.findById(savedComponent.getId());
        assertFalse(foundComponent.isPresent());
    }

    @Test
    public void testComponentRepositoryExists() {

        Component savedComponent = componentRepository.save(component);


        assertTrue(componentRepository.existsById(savedComponent.getId()));
    }
}