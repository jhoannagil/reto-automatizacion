# language: es
@GET
Característica: Consulta de registros
  Como usuario del API
  Quiero consultar los registros existentes

  Escenario: El usuario consume el api con el metodo get
    Dado que el usuario consume el api con el metodo get
    Cuando el usuario consulta el registro con id 1
    Entonces el usuario visualiza que el codigo de respuesta del get es 200
    Y el usuario valida que la informacion del registro sea correcta
      | id | title                                                                      | userId |
      |  1 | sunt aut facere repellat provident occaecati excepturi optio reprehenderit |      1 |
