# Note App

Esta es una aplicación hecha en Angular y en Spring boot que tiene como función crear y listar las notas ingresadas por el usuario, donde la capa de persistencia es gestionada en archivos de texto, creando una carpeta (al hacer una analogía con SQL , esta sería la tabla ) y dentro de esta se creará por cada registro un archivo de texto y cada uno tendrá por nombre el id de la nota (siguiendo con la analogía, cada registro sería una fila de la tabla).

# Backend
El Backend fue hecho en Spring Boot, Gradle y Java 8 utilizando una arquitectura limpia.
Los endpoints disponibles para esta aplicación son:
| URL | DESCRIPCION |
|--|--|
| api/note/create-note | Permite crear una nota |
|api/note/update-note/{id}|Permite actualizar una nota por medio de su identificador|
| api/note/get-all-notes | Permite listar todas las notas creadas |
| api/note/delete-by-id/{id}| Permite eliminar una nota por medio de su identificador |


## Repositorio
Se utiliza el algoritmo [BPlusTree](https://github.com/jiaguofang/b-plus-tree) para un almacenamiento en memoria con una persistencia en disco por medio de archivos de texto.
La información es almacenada es formato JSON utilizando la librería Jackson.

# Frontend

El frontend fue desarrollado en Angular, usando Boostrap para la parte visual. Actualmente la aplicación tiene la funcionalidad de Crear y Listar notas.
El frontend se encuentra en la siguiente ruta: `src/main/webapp`

# Desarrollo
**Backend**
Ejecutar el siguiente comando, en la carpeta del proyecto
```
./gradlew bootRun
```

 **Frontend**
```
cd src/main/webapp
npm run start
```
# Generación de la Aplicación
Ejecutar el siguiente comando, en la carpeta del proyecto
```
./gradlew clean build
```
En la siguiente ruta `build/libs` se genera el artefacto. Es un **JAR** auto-ejecutable que contiene la aplicación backend y frontend.

Para ejecutar el **JAR** utilizar el siguiente comando, en la ruta `build/libs`
```
java -jar notes-0.0.1-SNAPSHOT.jar
```
Abrir el navegador en la siguiente url `http://localhost:8080/`.