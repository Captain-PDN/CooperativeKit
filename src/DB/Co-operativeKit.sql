CREATE DATABASE Cooperative;

CREATE TABLE Cooperative.User (
    `IDuser` VARCHAR(10) NOT NULL,
    `Username` VARCHAR(20) NOT NULL,
    `Password` VARCHAR(20) NOT NULL,
    `FirstName` VARCHAR(30) NOT NULL,
    `LastName` VARCHAR(30) NOT NULL,
    `Tel` VARCHAR(10) NOT NULL,
    `Address` VARCHAR(100) NOT NULL,
    `Email` VARCHAR(30) NOT NULL,
    `CitizenID` VARCHAR(13) NOT NULL,
    `Photo` VARCHAR(50) DEFAULT NULL,
    `Birthday` DATE NOT NULL,
    `Host` BOOLEAN NOT NULL,
    `Type` VARCHAR(7) NOT NULL,
    `Sex` VARCHAR(6) NOT NULL,
    PRIMARY KEY (`IDuser`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.History (
    `IDuser` VARCHAR(10) NOT NULL,
    `Date` DATE NOT NULL,
    `Time` TIME NOT NULL,
    `Log` VARCHAR(200) NOT NULL,
    FOREIGN KEY (`IDuser`) REFERENCES User(`IDuser`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.Chat (
    `IDuser` VARCHAR(10) NOT NULL,
    `IDuserOther` VARCHAR(10) NOT NULL,
    `Date` DATE  NOT NULL,
    `Time` TIME  NOT NULL,
    `ChatLog` VARCHAR(200) NOT NULL,
    FOREIGN KEY (`IDuser`) REFERENCES User(`IDuser`),
    FOREIGN KEY (`IDuserOther`) REFERENCES User(`IDuser`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.Goods (
    `IDGoods` VARCHAR(10) NOT NULL,
    `Photo` VARCHAR(50) DEFAULT NULL,
    `Price` DOUBLE NOT NULL,
    `Name` VARCHAR(20) NOT NULL,
    `Type` VARCHAR(20)  NOT NULL,
    PRIMARY KEY (`IDGoods`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.Werehouse (
    `IDWerehouse` VARCHAR(10) NOT NULL,
    `IDGoods` VARCHAR(10) NOT NULL,
    `Quantity` INT NOT NULL,
    PRIMARY KEY (`IDWerehouse`),
    FOREIGN KEY (`IDGoods`) REFERENCES Goods(`IDGoods`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.CooperativeRoom (
    `IDCoopRoom` VARCHAR(10) NOT NULL,
    `IDuser` VARCHAR(10) NOT NULL,
    `IDWerehouse` VARCHAR(10) NOT NULL,
    `Name` VARCHAR(20)  NOT NULL,
    `Status` VARCHAR(20)  NOT NULL,
    `Type` VARCHAR(20)  NOT NULL,
    `DateCreate` DATE  NOT NULL,
    `EnteringCount` INT  NOT NULL,
    PRIMARY KEY (`IDCoopRoom`),
    FOREIGN KEY (`IDuser`) REFERENCES User(`IDuser`),
    FOREIGN KEY (`IDWerehouse`) REFERENCES Werehouse(`IDWerehouse`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.CooperativeRoomMember (
    `IDCoopRoom` VARCHAR(10) NOT NULL,
    `IDuserMember` VARCHAR(10) NOT NULL,
    FOREIGN KEY (`IDCoopRoom`) REFERENCES CooperativeRoom(`IDCoopRoom`),
    FOREIGN KEY (`IDuserMember`) REFERENCES User(`IDuser`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Cooperative.Audit (
    `IDaudit` VARCHAR(10) NOT NULL,
    `IDuser` VARCHAR(10) NOT NULL,
    `IDGoods` VARCHAR(10) NOT NULL,
    `Name` VARCHAR(20) NOT NULL,
    `Quantity` INT NOT NULL,
    `Price` DOUBLE NOT NULL,
    `Total` DOUBLE NOT NULL,
    PRIMARY KEY (`IDaudit`),
    FOREIGN KEY (`IDuser`) REFERENCES User(`IDuser`),
    FOREIGN KEY (`IDGoods`) REFERENCES Goods(`IDGoods`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;