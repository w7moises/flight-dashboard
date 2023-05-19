
## Iniciar la aplicación en local
Correr `npm install` para instalar paquetes de node.

Correr `ng serve` para inicializar el servidor y luego ir a la ruta `http://localhost:4200/`.

## Iniciar la aplicación en docker
Usar los siguientes comandos:

`docker build -t frontend .`

`docker run --name frontend -p 4200:80 frontend`

y luego ir a la ruta `http://localhost:4200/`