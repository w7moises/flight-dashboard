# Practica

Este proyecto fue creado en Spring boot 3.0.0

## Development server

Para correr el proyecto se debe generar el contenedor docker.
Seguir estos pasos:

1. Modificar el docker-compose.yml de acuerdo a sus requisitos
2. Generar jar con el comando `mvn clean package` o `mvn clean install`
3. Ejecutar el comando `docker-compose up -d`
4. Insertar los querys de data.sql en la base de datos para tener datos de prueba