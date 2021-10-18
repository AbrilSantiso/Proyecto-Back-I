# Proyecto-Back-I: API REST - Clinica Odontologica

Esta API fue realizada como proyecto integrador de la materia Backend I, podes ver la consigna [acá](https://docs.google.com/document/d/1WWAushxuiv35CR3xMlotsx9fRNEOT2JX/edit).
Permite crear, modificar, eliminar, buscar y listar odontologos, pacientes y turnos (todos los turnos o solamente los de la proxima semana).  

## Stack 
- JAVA 11
- Maven
- Spring MVC
- Hibernate
- Spring Starter Security
- H2 Database
- Log4J
- JUnit
- Documentación con springdoc-openapi y Swagger.

## Endpoints
  
### Pacientes

-  Buscar por id: `GET` a `PATH/buscarId/{id}`
    -  `200 OK` → devuelve el paciente
    -  `404 NOT FOUND` → No se encontró al paciente con el id {id}

-  Crear un paciente: `POST` a `PATH/pacientes/nuevo`
    -  `200 OK` → se registró correctamente
    -  `400 BAD REQUEST` → Hay un error en los datos enviados
        ```json
        {
            "nombre": Martina",
            "apellido": "Gonzalez",
            "dni": "123456789",
            "domicilio": {
                          "calle": "calle 1",
                          "numero": "621",
                          "localidad": "Córdoba",
                          "provincia": "Córdoba"
                         }
        }
        ```
    
-  Actualizar existente: `PUT` a `PATH/pacientes/actualizar`
    -  `200 OK` → se actualizó correctamente
    -  `400 BAD REQUEST` → Hubo un error en los datos recibidos
    -  `404 NOT FOUND` → no se encontró el paciente con id recibido
        ```json
        {
            "id": "1",
            "nombre": Martina",
            "apellido": "Gonzalez",
            "dni": "123456789",
            "domicilio": {
                          "calle": "calle 1",
                          "numero": "621",
                          "localidad": "Córdoba",
                          "provincia": "Córdoba"
                         }
        }
        ```
    
-  Eliminar por id: `DELETE` a `PATH/pacientes/{id}`
    -  `204 NO CONTENT` → se borró correctamente
    -  `404 NOT FOUND` → no se encontró el paciente con id recibido


-  Obtener todos: `GET` a `PATH/pacientes`
 
