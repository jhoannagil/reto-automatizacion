# language: es
@PUT
Característica: Actualización de registros
  Como usuario de la API
  Quiero actualizar un registro existente
  Para modificar la información almacenada en el sistema

  Escenario: El usuario actualiza un registro exitosamente con el metodo PUT
    Dado que el usuario quiere actualizar un registro en la API
    Cuando el usuario envia los datos actualizados del registro
      | title                 | body                                | userId |
      | Actualizacion de Jhoa | Esta es una prueba de actualizacion |      1 |
    Entonces el usuario visualiza que el codigo de respuesta del put es 200
    Y verifica que el registro se actualizo con la informacion enviada
      | title                 | body                                | userId |
      | Actualizacion de Jhoa | Esta es una prueba de actualizacion |      1 |
