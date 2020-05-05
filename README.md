# ASIO - Procesador de entrada

Procesador de datos del módulo de entrada para el proyecto Backend SGI (ASIO). 

## OnBoarding

Para iniciar el entorno de desarrollo se necesita cumplir los siguientes requisitos:

* OpenJDK 11 (en caso de querer JDK8: Oracle JDK 8)
* Eclipse JEE 2019-09 con plugins:
** Spring Tools 4
** m2e-apt
** Lombok
* Docker

También se debe instalar el entorno de desarrollo acorde con lo explicado en: [https://corpus.izertis.com/arquitectura/java/configuracion-del-entorno](https://corpus.izertis.com/arquitectura/java/configuracion-del-entorno)


### Instalar Lombok

Para la instalación de Lombok, es preciso descargar la última versión desde [https://projectlombok.org/download](https://projectlombok.org/download). Se descargará un jar que precisa ser ejecutado:

	java -jar lombok.jar

Se seleccionará la ubicación en la que se encuentra instalado Eclipse.

En caso que de problemas a la hora de generar las clases de Mapstruct, es preciso utilizar una versión parcheada de lombok. Para ello, se ha dejado en \\rackstation\Desarrollo\fuentes\Entorno de desarrollo\Eclipses el fichero lombok-patched-1.18.6.jar. Se deberá configurar en el fichero eclipse.ini, sustituyendo el jar que tiene configurado actualmente por el parcheado

```
-javaagent:C:\desarrollo\java\install\eclipse-jee-2018-12-R-win32-x86_64\lombok-patched-1.18.6.jar
```

## Java 11

La aplicación está preparada para funcionar con JDK 11. En caso de necesitar trabajar con un JDK anterior, es preciso especificar una propiedad en el POM:

```xml
<properties>
	<java.version>1.8</java.version>
</properties>
```

## Enviar mensajes a general-data 

Si queremos saltarnos el proceso ETL y mandar directamente los datos processados de la cola *input-data* a *general-data* basta con configurar
la propiedad send-general-data-topic a true, false en caso contrario.

```xml 
app:
  kafka:
    send-general-data-topic: true
```


## Instalación en entorno real

Será preciso configurar las siguientes variables de entorno cuando se instale en un entorno real:

|Variable|Descripción|Valor por defecto|
|---|---|---|
|`APP_KAFKA_INPUT_TOPIC_NAME`|Nombre del topic de Kafka de entrada|input-data|
|`APP_KAFKA_GENERAL_TOPIC_NAME`|Nombre del topic de Kafka general|general-data|
|`APP_KAFKA_CREATE_TOPICS`|Flag que indica si debe crear automáticamente los topics de Kafka. Valores admisibles `true` y `false`|false|
| `SPRING_KAFKA_BOOTSTRAP_SERVERS` | URL del servicio de Kafka para los productores | localhost:29092 |
| `SPRING_KAFKA_CONSUMER_BOOTSTRAP_SERVERS` | URL del servicio de Kafka para los consumidores | localhost:29092 |
| `SPRING_KAFKA_CONSUMER_GROUP_ID` | ID del grupo de consumidores | input-processor |
|`APP_PERSISTENCE_DATASOURCE_USERNAME`|Nombre del usuario de acceso a la base de datos| |
|`APP_PERSISTENCE_DATASOURCE_PASSWORD`|Contraseña del usuario de acceso a la base de datos| |
|`APP_PERSISTENCE_DATASOURCE_URL`|URL de acceso a la base de datos MariaDB|jdbc:mysql://localhost:3307/app?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&createDatabaseIfNotExist=true|
|`APP_KAFKA_SEND_GENERAL_DATA_TOPIC`|Flag que indica si se deben enviar los datos a la siguiente cola sin pasar por ETL. Valores admisibles `true` y `false`|true|
|`APP_SERVICES_ETL_ENDPOINT`| URL del servicio para invocar el proceso ETL | http://localhost:8080/kettle/runJob |
|`APP_SERVICES_ETL_JOB`| Nombre del job que se invocará al hacer la llamada al proceso ETL | main |
|`APP_SERVICES_ETL_PATH`| Path del repositorio de Pentaho |  |

