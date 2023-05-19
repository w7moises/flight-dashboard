From node:18-alpine as build-step
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:latest
COPY --from=build-step /app/dist/practica /usr/share/nginx/html

EXPOSE 80