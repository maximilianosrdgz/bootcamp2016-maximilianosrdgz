-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-09-27 17:49:36.058

-- tables
-- Table: ExtendedForecasts
CREATE TABLE ExtendedForecasts (
    idExtendedForecast int  NOT NULL,
    idForecast int  NOT NULL,
    date date  NOT NULL,
    weekDay varchar(20)  NOT NULL,
    maxTemp decimal(4,2)  NOT NULL,
    minTemp decimal(4,2)  NOT NULL,
    description varchar(50)  NOT NULL,
    CONSTRAINT ExtendedForecasts_pk PRIMARY KEY  (idExtendedForecast,idForecast)
);

-- Table: Forecasts
CREATE TABLE Forecasts (
    idForecast int  NOT NULL,
    humidity decimal(4,2)  NOT NULL,
    preassure decimal(4,2)  NOT NULL,
    visibility decimal(4,2)  NOT NULL,
    speed decimal(5,2)  NOT NULL,
    direction decimal(4,2)  NOT NULL,
    date date  NOT NULL,
    weekDay varchar(20)  NOT NULL,
    maxTemp decimal(4,2)  NOT NULL,
    minTemp decimal(4,2)  NOT NULL,
    description varchar(50)  NOT NULL,
    city varchar(40)  NOT NULL,
    country varchar(40)  NOT NULL,
    region varchar(40)  NOT NULL,
    CONSTRAINT Forecasts_pk PRIMARY KEY  (idForecast)
);

-- foreign keys
-- Reference: ExtendedForecasts_Forecasts (table: ExtendedForecasts)
ALTER TABLE ExtendedForecasts ADD CONSTRAINT ExtendedForecasts_Forecasts
    FOREIGN KEY (idForecast)
    REFERENCES Forecasts (idForecast);

-- End of file.

