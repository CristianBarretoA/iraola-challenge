# Iraola Challenge

## Ejecución local

El Proyecto se encuentra dockerizado, con lo cual se requieren realizar los siguientes pasos para su despliegue

Primero generamos la el JAR del proyecto y lo copiamos al volumen, parar ello en la ruta raiz del proyecto ejecutamos
los siguientes comandos:

```
./mvnw clean package -DskipTests
cp target/iraola-challenge-0.0.1-SNAPSHOT.jar src/main/docker
```
**Note:** *Se recomienda tener instalado maven en la maquina para la creacion del JAR*

Luego de generado el JAR vamos a levantar el contenedor, para estos nos dirijimos a la ruta ```/src/main/docker``` y ejecutamos el  comando
``` docker-compose up```. Una vez finalice la inicializacion de Spring prodra consumir la api en la url ```localhost:8080```.

### Endpoints

Todos los endpoints pueden ser visualizado en el siguiente [repositorio](https://documenter.getpostman.com/view/6683968/UVksLtt2) de Postman.

**Puede hacer uso de la ruta https://iraola-challenge.herokuapp.com para usar la aplicacion de manera WEB, esta se encuentra hosteada en Heroku con una Base de datos PGSQL corriendo en Google Cloud**
