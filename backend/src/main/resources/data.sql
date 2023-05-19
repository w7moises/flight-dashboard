-- bytedb.aereolineas definition

CREATE TABLE `aereolineas`
(
    `airline_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `airline_code` varchar(255) NOT NULL,
    `airline_name` varchar(255) NOT NULL,
    PRIMARY KEY (`airline_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.aereopuertos definition

CREATE TABLE `aereopuertos`
(
    `airport_id`       bigint(20)   NOT NULL AUTO_INCREMENT,
    `airport_location` varchar(255) NOT NULL,
    `airport_name`     varchar(255) NOT NULL,
    `other_details`    varchar(255) NOT NULL,
    PRIMARY KEY (`airport_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.agentes definition

CREATE TABLE `agentes`
(
    `agent_id`      bigint(20)   NOT NULL AUTO_INCREMENT,
    `agent_details` varchar(255) NOT NULL,
    `agent_name`    varchar(50)  NOT NULL,
    PRIMARY KEY (`agent_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.aviones definition

CREATE TABLE `aviones`
(
    `aircraft_id` bigint(20)   NOT NULL AUTO_INCREMENT,
    `capacity`    bigint(20)   NOT NULL,
    `maker`       varchar(255) NOT NULL,
    `model`       varchar(255) NOT NULL,
    PRIMARY KEY (`aircraft_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.costos definition

CREATE TABLE `costos`
(
    `cost_id`            bigint(20)     NOT NULL AUTO_INCREMENT,
    `flight_cost`        decimal(38, 2) NOT NULL,
    `valid_from_date`    datetime       NOT NULL,
    `valid_to_date`      datetime       NOT NULL,
    `airline_airline_id` bigint(20) DEFAULT NULL,
    `flight_flight_id`   bigint(20) DEFAULT NULL,
    PRIMARY KEY (`cost_id`),
    KEY `FK8ue1cusii1r2rd270h3f5qsjq` (`airline_airline_id`),
    KEY `FK26g8xpurptkc1j17e3ttp3gnq` (`flight_flight_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.escalas definition

CREATE TABLE `escalas`
(
    `leg_id`                         bigint(20)   NOT NULL AUTO_INCREMENT,
    `actual_arrival_date`            datetime   DEFAULT NULL,
    `actual_arrival_time`            varchar(255) NOT NULL,
    `actual_departure_date`          datetime   DEFAULT NULL,
    `actual_departure_time`          varchar(255) NOT NULL,
    `destination_airport_airport_id` bigint(20) DEFAULT NULL,
    `flight_flight_id`               bigint(20) DEFAULT NULL,
    `origin_airport_airport_id`      bigint(20) DEFAULT NULL,
    PRIMARY KEY (`leg_id`),
    KEY `FKol2omv64mfnjifjx8bxqiy436` (`destination_airport_airport_id`),
    KEY `FK865l312v1lj0cxfeiimooask` (`flight_flight_id`),
    KEY `FK7uwchy43gnb48piopgp3lx7yo` (`origin_airport_airport_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.pagos definition

CREATE TABLE `pagos`
(
    `payment_id`                 bigint(20)     NOT NULL AUTO_INCREMENT,
    `payment_amount`             decimal(38, 2) NOT NULL,
    `payment_date`               datetime       NOT NULL,
    `status`                     varchar(255) DEFAULT NULL,
    `reservation_reservation_id` bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`payment_id`),
    KEY `FK71lbbpmk8mt3whedim1cj37kc` (`reservation_reservation_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.pasajeros definition

CREATE TABLE `pasajeros`
(
    `passenger_id`  bigint(20)   NOT NULL AUTO_INCREMENT,
    `city`          varchar(255) NOT NULL,
    `country`       varchar(255) NOT NULL,
    `email_address` varchar(255) NOT NULL,
    `first_name`    varchar(255) NOT NULL,
    `last_name`     varchar(255) NOT NULL,
    `other_details` varchar(255) NOT NULL,
    `phone_number`  varchar(255) NOT NULL,
    `second_name`   varchar(255) NOT NULL,
    PRIMARY KEY (`passenger_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.reservas definition

CREATE TABLE `reservas`
(
    `reservation_id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `number_in_party`         bigint(20)   NOT NULL,
    `reservation_date`        datetime     NOT NULL,
    `reservation_status_code` varchar(255) NOT NULL,
    `ticket_code`             varchar(6)   NOT NULL,
    `travel_type_class`       varchar(255) NOT NULL,
    `agent_agent_id`          bigint(20) DEFAULT NULL,
    `leg_leg_id`              bigint(20) DEFAULT NULL,
    `passenger_passenger_id`  bigint(20) DEFAULT NULL,
    PRIMARY KEY (`reservation_id`),
    KEY `FKkt5qvbevrfu51egqt2912q7km` (`agent_agent_id`),
    KEY `FK36dopqe7f9q2gy2c213cned22` (`leg_leg_id`),
    KEY `FKs18jlx7gs08qivogd3q3hbkf3` (`passenger_passenger_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.tokens definition

CREATE TABLE `tokens`
(
    `id`         int(11) NOT NULL,
    `expired`    bit(1)  NOT NULL,
    `revoked`    bit(1)  NOT NULL,
    `token`      varchar(255) DEFAULT NULL,
    `token_type` varchar(255) DEFAULT NULL,
    `user_id`    int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_na3v9f8s7ucnj16tylrs822qj` (`token`),
    KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.tokens_seq definition

CREATE TABLE `tokens_seq`
(
    `next_val` bigint(20) DEFAULT NULL
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.users definition

CREATE TABLE `users`
(
    `id`         int(11)      NOT NULL AUTO_INCREMENT,
    `email`      varchar(255) NOT NULL,
    `first_name` varchar(255) NOT NULL,
    `last_name`  varchar(255) NOT NULL,
    `password`   varchar(255) DEFAULT NULL,
    `role`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;


-- bytedb.vuelos definition

CREATE TABLE `vuelos`
(
    `flight_id`                      bigint(20)   NOT NULL AUTO_INCREMENT,
    `arrival_date`                   datetime     NOT NULL,
    `arrival_time`                   varchar(255) NOT NULL,
    `departure_date`                 datetime     NOT NULL,
    `departure_time`                 varchar(255) NOT NULL,
    `airline_airline_id`             bigint(20) DEFAULT NULL,
    `airplane_aircraft_id`           bigint(20) DEFAULT NULL,
    `destination_airport_airport_id` bigint(20) DEFAULT NULL,
    `origin_airport_airport_id`      bigint(20) DEFAULT NULL,
    PRIMARY KEY (`flight_id`),
    KEY `FKnr9mvf5h2ec1gnk7d1j0evrxi` (`airline_airline_id`),
    KEY `FKqqinor956veaqfa4iave2f2th` (`airplane_aircraft_id`),
    KEY `FKicvbatmsi447q27uxlmhd9bqo` (`destination_airport_airport_id`),
    KEY `FK4m5shxkt3wr8cnbds1615pvns` (`origin_airport_airport_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;
#Token
insert into bytedb.tokens_seq (next_val)
VALUES (0);

#Aviones
insert into bytedb.aviones(model, maker, capacity)
values ('Boeing 747', 'EEUU Refiner', 500);
insert into bytedb.aviones(model, maker, capacity)
values ('Boeing 777', 'EEUU Refiner', 400);
insert into bytedb.aviones(model, maker, capacity)
values ('Boeing 787', 'EEUU Refiner', 300);
insert into bytedb.aviones(model, maker, capacity)
values ('Airbus A380', 'Airbus', 500);
insert into bytedb.aviones(model, maker, capacity)
values ('Airbus A350', 'Airbus', 400);
insert into bytedb.aviones(model, maker, capacity)
values ('Airbus A330', 'Airbus', 300);
#Aereolineas
insert into bytedb.aereolineas(airline_name, airline_code)
values ('American Airlines', 'AA');
insert into bytedb.aereolineas(airline_name, airline_code)
values ('Delta Airlines', 'DL');
insert into bytedb.aereolineas(airline_name, airline_code)
values ('United Airlines', 'UA');
insert into bytedb.aereolineas(airline_name, airline_code)
values ('Air France', 'AF');
insert into bytedb.aereolineas(airline_name, airline_code)
values ('British Airways', 'BA');
#Aereopuertos
insert into bytedb.aereopuertos(airport_name, airport_location, other_details)
values ('Jorge Chavez 1', 'Av. Elmer Faucett s/n, Callao 07031', 'El más grande del Perú');
insert into bytedb.aereopuertos(airport_name, airport_location, other_details)
values ('Jorge Chavez 2', 'Av. Elmer Faucett s/n, Callao 07031', 'El más grande del Perú');
insert into bytedb.aereopuertos(airport_name, airport_location, other_details)
values ('Jorge Chavez 3', 'Av. Elmer Faucett s/n, Callao 07031', 'El más grande del Perú');
insert into bytedb.aereopuertos(airport_name, airport_location, other_details)
values ('Jorge Chavez 4', 'Av. Elmer Faucett s/n, Callao 07031', 'El más grande del Perú');
#Usuarios
INSERT INTO bytedb.users (email, first_name, last_name, password, `role`)
VALUES ('agente@gmail.com', 'Walter', 'Molina', '$2a$10$0Q0zupWFx1m4j80fbrCoTuRsgWPWQBUiy0g3vTn.sNCGpNMBUxXjC',
        'ROLE_AGENT'),
       ('supervisor@gmail.com', 'Walter', 'Molina', '$2a$10$qjlWAs8aNr3zQwHgi0aSh.b/teAcAC.E5zw2khDqWJ0L0Zmph7bdy',
        'ROLE_SUPERVISOR'),
       ('w7moises@gmail.com', 'Walter', 'Molina Paucar', '$2a$10$u0A2f296DXTemCKIN9pS4ey4/A/KZof949xYuu0XGOaE/iTPozAWq',
        'ROLE_PASSENGER');
#Tokens
INSERT INTO bytedb.tokens (id, expired, revoked, token, token_type, user_id)
VALUES (1, 1, 1,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZ2VudGVAZ21haWwuY29tIiwiaWF0IjoxNjg0NTI1NDkzLCJleHAiOjE2ODQ1Mzk4OTN9.g3cPSKnIxvvSDmKp7QYxLSOmEoL5v0qDTtXDSS0GkoA',
        'BEARER', 2),
       (2, 1, 1,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcnZpc29yQGdtYWlsLmNvbSIsImlhdCI6MTY4NDUyNTUyMywiZXhwIjoxNjg0NTM5OTIzfQ.0hKJ8bGv98eUMa_yzq3b05Mr3ePYKM5l5XecJYuc92o',
        'BEARER', 3),
       (3, 1, 1,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZ2VudGVAZ21haWwuY29tIiwiaWF0IjoxNjg0NTI1NTQ2LCJleHAiOjE2ODQ1Mzk5NDZ9.uGwq4d30TVmLhuk_KPj6yLunMP-PXuULIJMeYtjDbdc',
        'BEARER', 2),
       (4, 1, 1,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3N21vaXNlc0BnbWFpbC5jb20iLCJpYXQiOjE2ODQ1MjU3MTIsImV4cCI6MTY4NDU0MDExMn0.aSGeyXF3UZXYt7Fm4HT15H6FJLaKiIRt7MdnTXxqNWg',
        'BEARER', 4),
       (5, 1, 1,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcnZpc29yQGdtYWlsLmNvbSIsImlhdCI6MTY4NDUyNTczNywiZXhwIjoxNjg0NTQwMTM3fQ.FvSjUiFt_4uBs_e5p5kW2OMTR_jcOEwxL84Wvei0UF4',
        'BEARER', 3),
       (6, 0, 0,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcnZpc29yQGdtYWlsLmNvbSIsImlhdCI6MTY4NDUyNTgyOCwiZXhwIjoxNjg0NTQwMjI4fQ.BX-RzQ6mrQGb0ROG-icFnyyymoIvGTQj4guv2PYjEoo',
        'BEARER', 3),
       (7, 1, 1,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3N21vaXNlc0BnbWFpbC5jb20iLCJpYXQiOjE2ODQ1MjU5NDQsImV4cCI6MTY4NDU0MDM0NH0.gwjrmLEEsKSxb1gsHLJ9JXTBibAQ6cMjdqlrqwMh9VE',
        'BEARER', 4),
       (8, 0, 0,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZ2VudGVAZ21haWwuY29tIiwiaWF0IjoxNjg0NTI1OTUzLCJleHAiOjE2ODQ1NDAzNTN9.9di4EAqCkKa432kMLrrMjLC5ClDP_SzQ85M3cm-sASg',
        'BEARER', 2),
       (9, 0, 0,
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3N21vaXNlc0BnbWFpbC5jb20iLCJpYXQiOjE2ODQ1MjU5ODUsImV4cCI6MTY4NDU0MDM4NX0.K1S2-K0DwpDI4pejQ4agaqzxTatzv7J7ncuiLEFWCTQ',
        'BEARER', 4);
#Pasajeros
INSERT INTO bytedb.pasajeros (city, country, email_address, first_name, last_name, other_details, phone_number,
                              second_name)
VALUES ('San Miguel', 'Peru', 'w7moises@gmail.com', 'Walter', 'Molina Paucar', 'Le gusta viajar a europa', '972250768',
        'Moises');
#Agentes
INSERT INTO bytedb.agentes (agent_details, agent_name)
VALUES ('El mejor del mundo', 'Jhon Trivago');
#Vuelos
INSERT INTO bytedb.vuelos (arrival_date, arrival_time, departure_date, departure_time, airline_airline_id,
                           airplane_aircraft_id, destination_airport_airport_id, origin_airport_airport_id)
VALUES ('2023-05-19 19:00:00', '14:55', '2023-05-18 19:00:00', '14:52', 2, 2, 4, 1);
#Escalas
INSERT INTO bytedb.escalas (actual_arrival_date, actual_arrival_time, actual_departure_date, actual_departure_time,
                            destination_airport_airport_id, flight_flight_id, origin_airport_airport_id)
VALUES ('2023-05-19 19:00:00', '14:54', '2023-05-18 19:00:00', '14:55', 3, 1, 1);
#Costos
INSERT INTO bytedb.costos (flight_cost, valid_from_date, valid_to_date, airline_airline_id, flight_flight_id)
VALUES (300.00, '2023-05-18 19:00:00', '2023-05-19 19:00:00', 2, 1);
#Reservas
INSERT INTO bytedb.reservas (number_in_party, reservation_date, reservation_status_code, ticket_code, travel_type_class,
                             agent_agent_id, leg_leg_id, passenger_passenger_id)
VALUES (400, '2023-05-19 14:53:00', 'EN_PROCESO', 'RV001', 'EJECUTIVO', 1, 1, 1);