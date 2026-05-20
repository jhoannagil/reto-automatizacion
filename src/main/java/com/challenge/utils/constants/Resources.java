package com.challenge.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Resources {

    // Aquí defines los endpoints de tu API
    // Ejemplo:
    // GET_USER_ENDPOINT("/users/{id}"),
    // CREATE_USER_ENDPOINT("/users");

    EXAMPLE_ENDPOINT("/example");

    private final String path;
}
