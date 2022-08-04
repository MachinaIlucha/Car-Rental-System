CREATE TABLE IF NOT EXISTS CR_users(
    id                  INT GENERATED ALWAYS AS IDENTITY,
    firstName           VARCHAR(20),
    lastName            VARCHAR(30),
    login               VARCHAR(40),
    password            VARCHAR(20),
    email               VARCHAR(255),
    phone               VARCHAR(20),
    birthDate           TIMESTAMP,
    pesel               VARCHAR(11),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS CR_roles(
    id                  INT GENERATED ALWAYS AS IDENTITY,
    name                VARCHAR(12) UNIQUE NOT NULL CHECK(name IN ('CUSTOMER', 'ADMIN')),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS CR_usersRoles(
    user_id             INT NOT NULL,
    role_id             INT NOT NULL,
    CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES CR_users(id),
    CONSTRAINT fk_role_id
        FOREIGN KEY(role_id)
            REFERENCES CR_roles(id)
);

CREATE TABLE IF NOT EXISTS CR_locations(
    id                  INT GENERATED ALWAYS AS IDENTITY,
    country             VARCHAR(50) NOT NULL,
    city                VARCHAR(100) NOT NULL,
    address             VARCHAR(100) NOT NULL,
    email               VARCHAR(255) NOT NULL,
    phone               VARCHAR(20) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS CR_cars(
    id                  INT GENERATED ALWAYS AS IDENTITY,
    registration        VARCHAR(20) NOT NULL UNIQUE ,
    brand               VARCHAR(50) NOT NULL,
    model               VARCHAR(50) NOT NULL,
    dailyFee            decimal(15,2) NOT NULL,
    locationId          INT NOT NULL,
    vehicleStatus       BOOLEAN NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(locationId) REFERENCES CR_locations(id)
);

CREATE TABLE IF NOT EXISTS CR_carParameters(
     carId              INT NOT NULL UNIQUE ,
     bodytype           VARCHAR(30) NOT NULL,
     productionYear     INT NOT NULL,
     fuelType           VARCHAR(30) NOT NULL,
     power              INT NOT NULL,
     gearbox            VARCHAR(30) NOT NULL,
     frontWheelDrive    BOOLEAN NOT NULL,
     doorsNumber        INT NOT NULL,
     seatsNumber        INT NOT NULL,
     color              VARCHAR(30) NOT NULL,
     metallic           BOOLEAN NOT NULL,
     photoName          VARCHAR(70) NOT NULL,
     description        VARCHAR(100) NOT NULL,
     FOREIGN KEY (carId) REFERENCES CR_cars(id)
);