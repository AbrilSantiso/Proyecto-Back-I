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
    -  `200 OK` → Se creo correctamente
    -  `400 BAD REQUEST` → Hay un error en los datos enviados
        ```json
        {
            "nombre": "Martina",
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
    
-  Actualizar un paciente existente: `PUT` a `PATH/pacientes/actualizar`
    -  `200 OK` → se actualizó correctamente
    -  `400 BAD REQUEST` → Hay un error en los datos recibidos
    -  `404 NOT FOUND` → No se encontró el paciente con id recibido
        ```json
        {
            "id": "1",
            "nombre": "Martina",
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
    
-  Eliminar por id: `DELETE` a `PATH/pacientes/eliminarId/{id}`
    -  `200 OK` → Se elimino correctamente
    -  `404 NOT FOUND` → No se encontró al paciente con el id {id}


-  Consultar todos: `GET` a `PATH/pacientes/todos`



### Odontólogos

-  Buscar por id: `GET` a `PATH/odontologos/buscarId/{id}`
    -  `200 OK` → devuelve el odontólogo
    -  `404 NOT FOUND` → No se encontro el odontologo
    -  
-  Crear nuevo odontologo: `POST` a `PATH/odontologos/nuevo`
    -  `200 OK` →   Se creo correctamente
    -  `400 BAD REQUEST` → Hay un error en los datos recibidos
          ```json
            {
                "nombre": "Andrea",
                "apellido": "Gomez",
                "matricula": "1236"
            }
          ```
        
-  Actualizar existente: `PUT` a `PATH/odontologos/actualizar`
    -  `200 OK` → Se actualizo correctamente
    -  `400 BAD REQUEST` → Hubo un error en los datos recibidos
    -  `404 NOT FOUND` → No se encontro el odontologo con el id recibido
          ```json
          {
              "id": "1",
              "nombre": "Andrea",
              "apellido": "Gomez",
              "matricula": "1236"
          }
          ```
        
-  Eliminar por id: `DELETE` a `PATH/odontologos/eliminarId/{id}`
    -  `200 OK` → Se elimino correctamente
    -  `404 NOT FOUND` → No se encontró el odontólogo con id recibido


-  Consultar todos: `GET` a `PATH/odontologos/todos`
  


### Turnos
    
-  Buscar por id: `GET` a `PATH/turnos/buscarId/{id}`
    -  `200 OK` → Devuelve el turno
    -  `404 NOT FOUND` → No se encontró un turno con ese ID

-  Registrar nuevo turno: `POST` a `PATH/turnos/nuevo`
    -  `200 OK` → Se registró correctamente
    -  `400 BAD REQUEST` → Hubo un error en los datos recibidos
        ```json
        {
            "paciente": {"id": "1"},
            "odontologo": {"id": "1"},
            "fechaYHora": "2021-11-23T17:00:00"
        }
        ```

-  Actualizar un turno existente: `PUT` a `PATH/turnos/actualizar`
    -  `200 OK` → Se actualizó correctamente
    -  `400 BAD REQUEST` → Hubo un error en los datos recibidos
    -  `404 NOT FOUND` → No se encontró el turno con id recibido
        ```json
        {
              "id": "1",
              "paciente": {"id": "1"},
              "odontologo": {"id": "1"},
              "fechaYHora": "2021-11-23T17:00:00"
        }
        ```
    
-  Eliminar por id: `DELETE` a `PATH/turnos/eliminarId/{id}`
    -  `200 NO CONTENT` → El turno se borró correctamente
    -  `404 NOT FOUND` → No se encontró el turno con id recibido


-  Consultar todos: `GET` a `PATH/turnos/todos`

-  Consultar solo los turnos de la proxima semana: `GET` a `PATH/turnos/proximaSemana`
 
