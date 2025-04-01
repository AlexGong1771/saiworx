package com.example.saiworx.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class ComponentTypeDeserializer extends JsonDeserializer<ComponentType> {
    @Override
    public ComponentType deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String value = jsonParser.getText().toUpperCase();
        try {
            return ComponentType.valueOf(value);
        } catch (IllegalArgumentException e) {
            return ComponentType.INVALID;
        }
    }
}
