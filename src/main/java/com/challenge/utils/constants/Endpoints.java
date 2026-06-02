package com.challenge.utils.constants;

public enum Endpoints {
    // Usado para POST (crear) y GET (listar todos)
    RECURSO_POSTS("/posts"),
    
    // Usado para PUT (actualizar), GET (uno solo) y DELETE
    RECURSO_POST_POR_ID("/posts/{id}");

    private final String url;

    Endpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
