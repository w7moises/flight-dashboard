#Truncate
truncate table bytedb.aviones;
truncate table bytedb.aereolineas;
#Aviones
insert into bytedb.aviones(model,maker,capacity) values ('Boeing 747', 'EEUU Refiner', 500);
insert into bytedb.aviones(model,maker,capacity) values ('Boeing 777', 'EEUU Refiner', 400);
insert into bytedb.aviones(model,maker,capacity) values ('Boeing 787', 'EEUU Refiner', 300);
insert into bytedb.aviones(model,maker,capacity) values ('Airbus A380', 'Airbus', 500);
insert into bytedb.aviones(model,maker,capacity) values ('Airbus A350', 'Airbus', 400);
insert into bytedb.aviones(model,maker,capacity) values ('Airbus A330', 'Airbus', 300);
#Aereolineas
insert into bytedb.aereolineas(airline_name, airline_code) values ('American Airlines', 'AA');
insert into bytedb.aereolineas(airline_name, airline_code) values ('Delta Airlines', 'DL');
insert into bytedb.aereolineas(airline_name, airline_code) values ('United Airlines', 'UA');
insert into bytedb.aereolineas(airline_name, airline_code) values ('Air France', 'AF');
insert into bytedb.aereolineas(airline_name, airline_code) values ('British Airways', 'BA');