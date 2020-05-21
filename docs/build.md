# Compilación

Se indicará a continuación los pasos que hay que seguir para llevar a cabo la generación del artefacto.

## Prerrequisitos

Se precisa disponer los siguientes elementos configurados:

* OpenJDK 11
* Maven 3.6.x

## Compilación

Para realizar la compilación se ejecutará el siguiente comando:

```bash
mvn clean package
```

En caso de querer generar al mismo tiempo Sources el comando siguiente: 

```bash
mvn clean package source:jar
```

También sería posible instalar o desplegar los artefactos sustituyendo `package` por `install` o `deploy` respectivamente.

Los artefactos se generarán dentro del directorio `target` de cada uno de los módulos:

### Back

Los artefactos se encuentran dentro de input-processor-back/target

* Artefacto: input-processor-back-{version}.jar
* Sources: input-processor-back-{version}-sources.jar

### Kafka

Los artefactos se encuentran dentro de input-processor-kafka/target

* Artefacto: input-processor-kafka-{version}.jar
* Sources: input-processor-kafka-{version}-sources.jar

### Service

Los artefactos se encuentran dentro de input-processor-service/target

* Artefacto: input-processor-service-{version}.jar
* Sources: input-processor-service-{version}-sources.jar

### Service Abstractions

Los artefactos se encuentran dentro de input-processor-service-abstractions/target

* Artefacto: input-processor-service-abstractions-{version}.jar
* Sources: input-processor-service-abstractions-{version}-sources.jar

### JPA Abstractions

Los artefactos se encuentran dentro de input-processor-jpa-abstractions/target

* Artefacto: input-processor-jpa-abstractions-{version}.jar
* Sources: input-processor-jpa-abstractions-{version}-sources.jar

### Swagger

Los artefactos se encuentran dentro de input-processor-swagger/target

* Artefacto: input-processor-swagger-{version}.jar
* Sources: input-processor-swagger-{version}-sources.jar
