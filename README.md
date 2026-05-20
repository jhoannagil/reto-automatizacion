# QA REST Screenplay Challenge - Jhoa

Proyecto de automatización de APIs REST utilizando el patrón de diseño Screenplay con Serenity BDD y JUnit 5.

## Tecnologías

- Java
- Gradle
- Serenity BDD Core, Screenplay, Screenplay REST, JUnit 5
- Lombok
- Jackson Databind
- AssertJ

## Estructura del Proyecto

El proyecto sigue una estructura limpia orientada al dominio y separada por responsabilidades bajo el enfoque Screenplay:
- `interactions`: Clases que representan cómo el actor interactúa con la API (Get, Post, Put, Delete).
- `tasks`: Secuencias de interacciones o pasos de negocio de alto nivel.
- `questions`: Clases para realizar validaciones sobre el estado o respuestas de la API.
- `models`: POJOs (Request / Response) mapeados con Lombok y Jackson.
- `utils`: Constantes (Endpoints en Enum), Configuraciones.
- `runners`: Suites o Runners de ejecución de pruebas.
- `resources/serenity.conf`: Archivo de configuración central de ambientes y properties de Serenity.

## Comandos

Ejecutar pruebas:
```bash
./gradlew clean test
```

Generar reporte de Serenity:
```bash
./gradlew reports
```
