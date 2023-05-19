# Practica

Este proyecto fue creado en Spring boot 3.0.0

## Iniciar en local
Para correr el proyecto en local se debe primero insertar manualmente el query de data.sql en la base de datos para tener datos de prueba.

## Iniciar en docker

Para correr el proyecto se debe generar el contenedor docker.
Seguir estos pasos:
Nota: la base de datos se rellena automaticamente con los datos de data.sql

1. Modificar el docker-compose.yml de acuerdo a sus requisitos
2. Generar jar con el comando `mvn clean package` o `mvn clean install`
3. Ejecutar el comando `docker-compose up -d`
4. Insertar los querys de data.sql en la base de datos para tener datos de prueba