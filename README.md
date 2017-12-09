# Demo Rest CXF

El clásico _Hello World_ como webservice rest con respuesta en formato json.

En la clase con la cual se implementa el webservice, por medio de anotaciones se indica todo
lo relativo al servicio, el path del mismo y cuales métodos se mapean a los verbos HTTP.

En el archivo [blueprint.xml](src/main/resources/OSGI-INF/blueprint/blueprint.xml) se declara el
servicio y la clase que lo implementa.

## Compilar e instalar
En la raiz del proyecto ejecutar

```
mvn clean install
```

Esto genera el paquete para desplegar en fuse y lo instala en el repositorio local del maven.

Para instalarlo en fuse ejecutar

```
install -s mvn:edesur.demo/hello-rest/1.0
```

Esto nos devuelve un id que identifica el módulo.

Ejecutando en la consola de fuse el comando ```list``` vamos a ver algo como lo siguiente

```
[ 290] [Active     ] [            ] [       ] [   80] hawtio :: Red Hat Fuse Branding (1.4.0.redhat-630187)
[ 291] [Active     ] [            ] [       ] [   80] Apache ServiceMix :: Specs :: JSR-311 API 1.1.1 (2.7.0)
[ 292] [Active     ] [            ] [       ] [   80] C__Java_jboss-fuse (6.3.0)
[ 312] [Active     ] [Created     ] [       ] [   80] hello-rest (1.0.0)
```

## Ejecutar
Apuntando el browser a http://localhost:8181/cxf/ vamos a ver los servicios disponibles, donde debería aparecer el que acabamos de instalar

Este demo soporta las siguientes verbos

### GET
La url es http://localhost:8181/hello/nombre

Retorna un string `Hello nombre`

Para ver la entrada que se registró en el log en la consola ejecutar el siguiente comando

```
log:display | grep Hello | tail 
```

### POST
En este caso se pasa un json con el siguiente formato

```
{
    "nombre": "Juan",
    "apellido": "Perez"
}
```

y retorna un json con el siguiente formato

```
{
    "mensaje": "Hola Juan Perez",
    "inEnglish": "Hello Mr. Juan Perez"
}
```

Para probarlo se requiere algún programa que nos permita ejecutar este tipo de llamadas, como por ejemplo [Postman](https://www.getpostman.com/).



