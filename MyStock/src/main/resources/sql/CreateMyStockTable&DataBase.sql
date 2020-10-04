CREATE DATABASE MyStock
GO
USE MyStock
GO
CREATE TABLE Users(
userid INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
account NVARCHAR(50) NOT NULL,
password NVARCHAR(50),
name NVARCHAR(50),
money INT
)
GO
CREATE TABLE Stocks(
stocksymbol NVARCHAR(50) PRIMARY KEY NOT NULL,
component NVARCHAR(50) NOT NULL,
price INT NOT NULL
)
GO