# language: es
Característica: Creación de registros
  Como usuario de la API
  Quiero crear un nuevo registro
  Para guardar nueva información en el sistema

  Escenario: El usuario crea un registro exitosamente con el método POST
    Dado que el usuario quiere crear un nuevo registro en la API
    Cuando el usuario envía los datos para crear el registro
    Entonces el usuario visualiza que el código de respuesta es 201
    Y verifica que el registro se creó con la información enviada
