CREATE DATABASE HotelManagement;

USE HotelManagement;

CREATE TABLE Funcionarios (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100),
    senha VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE Hospedes (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE Quartos (
    id INT AUTO_INCREMENT,
    tipo VARCHAR(50),
    reservado BOOLEAN DEFAULT FALSE,
    id_hospede INT,
    PRIMARY KEY(id),
    FOREIGN KEY (id_hospede) REFERENCES Hospedes(id)
);

CREATE TABLE Reservas (
    id INT AUTO_INCREMENT,
    id_hospede INT,
    id_quarto INT,
    data_reserva DATE,
    PRIMARY KEY(id),
    FOREIGN KEY (id_hospede) REFERENCES Hospedes(id),
    FOREIGN KEY (id_quarto) REFERENCES Quartos(id)
);
