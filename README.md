# Proyecto de API de Ecomerce

## Descripción

Este es un proyecto desarrollado en Java 23 con Spring Boot 3.3.4, que implementa una API de precios utilizando arquitectura hexagonal.

## Tecnologías Utilizadas

Java 23

Spring Boot 3.3.4

Spring Data JPA

Spring Security

H2 Database

OpenAPI Generator


## Instalación y Ejecución

Requisitos previos

Tener instalado Java 23

Tener Maven instalado

Pasos para ejecutar el proyecto

Clonar el repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
```
Acceder al directorio del proyecto:
```bash
cd ecomerce
```
Construir el proyecto con Maven:
```bash
mvn clean install
```
Ejecutar la aplicación:
```bash
mvn -pl bootstrap -am spring-boot:run
```
## Uso de la API

Puedes acceder a la documentación con Swagger en:

http://localhost:8080/swagger-ui/index.html

## Curl de ejemplo
```bash
curl -X 'GET' \
'http://localhost:8080/api/v1/prices?date=2020-06-14T00%3A00%3A00%2B02%3A00&productId=35455&brandId=1' \
-H 'accept: application/json'
```

## Pruebas

Para ejecutar los unitarios y de integración por separado:
```bash
mvn test
```
## Contacto

Si tienes alguna pregunta o sugerencia, puedes comunicarte con el autor del proyecto.



