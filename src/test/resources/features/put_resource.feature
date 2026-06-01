# language: es
Característica: Actualización de registros
  Como usuario de la API
  Quiero actualizar un registro existente
  Para modificar la información almacenada en el sistema

  Escenario: El usuario actualiza un registro exitosamente con el método PUT
    Dado que el usuario quiere actualizar un registro en la API
    Cuando el usuario envía los datos actualizados del registro
    Entonces el usuario visualiza que el código de respuesta del put es 200
    Y verifica que el registro se actualizó con la información enviada
