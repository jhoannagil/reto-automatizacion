# language: es
@DELETE
Característica: Eliminacion de registros
  Como usuario de la API
  Quiero eliminar un registro existente
  Para validar el correcto funcionamiento de la eliminacion

  Escenario: Eliminacion exitosa de un registro por su ID
    Dado que el usuario quiere eliminar un registro en la API
    Cuando el usuario elimina el registro con id 1
    Entonces el usuario visualiza que el codigo de respuesta del delete es 200
