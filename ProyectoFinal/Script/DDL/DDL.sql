-- database: ../../DataBase/RegistroEmpleado.sqlite
/*
CopyRight
autor: Jonathan Guaman
fecha: 28jul2024
description: creacion de las tablas para el registro de la información de los empleados
*/
DROP TABLE IF EXISTS RegistroMensual;
DROP TABLE IF EXISTS RegistroDiario;
DROP TABLE IF EXISTS RegistroPersonas;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS DiasFestivos;
DROP TABLE IF EXISTS Festividades;



--Esta tabla es para registrar una festividad
CREATE TABLE Festividades (
    festividad_id      INTEGER PRIMARY KEY AUTOINCREMENT
    ,descripcion        TEXT NOT NULL
);

/*Esta tabla es para registrar un dia festivo con referencia a las
festividades de la anterior tabla*/
CREATE TABLE DiasFestivos (
    dia_id             INTEGER PRIMARY KEY AUTOINCREMENT
    ,festividad_id      INTEGER NOT NULL
    ,numero_dia         INTEGER NOT NULL
    ,numero_mes         INTEGER NOT NULL
    ,FOREIGN KEY (festividad_id) REFERENCES Festividades (festividad_id)
);

/*Esta tabla es para registrar los grupos de ciertos tipos de elementos*/
CREATE TABLE CatalogoTipo(
    IDCatalogoTipo      INTEGER PRIMARY KEY autoincrement
    ,NombreCatalogoTipo VARCHAR(50) NOT NULL UNIQUE
    ,Descripcion        VARCHAR(90) NOT NULL
    ,Estado             VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCreacion      DATETIME DEFAULT (datetime('now', 'localtime'))
    ,FechaModificacion  DATETIME
);

/*Esta tabla registra los elementos que forman parte de cada grupo del Catalogo tipo*/
CREATE TABLE Catalogo(
    IDCatalogo         INTEGER PRIMARY KEY autoincrement
    ,IDCatalogoTipo    INTEGER NOT NULL REFERENCES CatalogoTipo(IDCatalogoTipo)
    ,NombreCatalogo    VARCHAR(50) NOT NULL UNIQUE
    ,Descripcion       VARCHAR(90) NOT NULL
    ,Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCreacion     DATETIME DEFAULT (datetime('now', 'localtime'))
    ,FechaModificacion DATETIME
);

/*Esta tabala regista los datos de las personas*/
CREATE TABLE RegistroPersonas
    (IDPersonas        /*1*/INTEGER PRIMARY KEY
    ,IDPersonaTipo     /*2*/INTEGER NOT NULL
    ,Nombre            /*3*/VARCHAR(15) NOT NULL
    ,SegundoNombre     /*4*/VARCHAR(15)
    ,Apellido          /*5*/VARCHAR(15) NOT NULL
    ,SegundoApellido   /*6*/VARCHAR(15)
    ,Cedula            /*7*/VARCHAR(10) NOT NULL UNIQUE
    ,Edad              /*8*/INTEGER NOT NULL
    ,IDGenero          /*9*/INTEGER NOT NULL
    ,Correo            /*10*/VARCHAR(50) NOT NULL UNIQUE
    ,Celular           /*11*/VARCHAR(50) NOT NULL UNIQUE
    ,Telefono          /*12*/VARCHAR(50)
    ,Estado            /*13*/VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,PagoDecimoTercero /*14*/VARCHAR(1) CHECK (PagoDecimoTercero  IN ('A','M'))
    ,PagoDecimoCuarto  /*15*/VARCHAR(1) CHECK (PagoDecimoCuarto  IN ('A','M'))
    ,IDMesVacacion     /*16*/INTEGER NOT NULL
    ,FechaCreacion     /*17*/DATETIME DEFAULT (datetime('now', 'localtime'))
    ,FechaModificacion /*18*/DATETIME
    ,Modificador       /*19*/INTEGER
    ,IDHorario         /*20*/INTEGER
    ,Sueldo            /*21*/DOUBLE NOT NULL
    ,CONSTRAINT        fk_RegistroPersonas_RegistroPersonas FOREIGN KEY (Modificador) REFERENCES RegistroPersonas(IDPersonas)
    --catalogo
    ,CONSTRAINT        fk_Catalogo_RegistroPersonas FOREIGN KEY (IDGenero) REFERENCES Catalogo(IDCatalogo)
    ,CONSTRAINT        fk_Catalogo_RegistroPersonas FOREIGN KEY (IDPersonaTipo) REFERENCES Catalogo(IDCatalogo)
    ,CONSTRAINT        fk_Catalogo_RegistroPersonas FOREIGN KEY (IDMesVacacion) REFERENCES Catalogo(IDCatalogo)
    ,CONSTRAINT        fk_Catalogo_RegistroPersonas FOREIGN KEY (IDHorario) REFERENCES Catalogo(IDCatalogo)
);

/*Esta tabla registra el ingreso y salida diaria de las personas*/
CREATE TABLE RegistroDiario
    (
        IDRegistroDiario   /*1*/INTEGER PRIMARY KEY autoincrement
        ,IDPersonas        /*2*/INTEGER NOT NULL
        ,HoraEntrada       /*3*/INTEGER NOT NULL
        ,MinutoEntrada     /*4*/INTEGER NOT NULL
        ,HoraSalida        /*5*/INTEGER
        ,MinutoSalida      /*6*/INTEGER
        ,NumeroDia         /*7*/INTEGER NOT NULL
        ,NumeroMes         /*8*/INTEGER NOT NULL
        ,NumeroAnio        /*8*/INTEGER NOT NULL
        ,EstadoEnt         /*9*/VARCHAR(1) DEFAULT('I') CHECK (EstadoEnt  IN ('A'/*atrasada*/,'I'/*Entró*/))
        ,EstadoSal         /*9*/VARCHAR(1) DEFAULT('X') CHECK (EstadoSal  IN ('X'/*todavia no sale*/,'S'/*Salió*/,'V'/*Salida antes*/))
        ,FechaRegistro    /*10*/DATETIME DEFAULT (datetime('now', 'localtime'))
        ,CONSTRAINT        fk_RegistroPersonas_RegistroDiario FOREIGN KEY (IDPersonas) REFERENCES RegistroPersonas(IDPersonas)
        UNIQUE (NumeroDia,NumeroMes,NumeroAnio)
    );

/*Esta tabla registra las horas trabajadas mensualmente de las personas*/
CREATE TABLE RegistroMensual
    (
        IDRegistroMensual     /*1*/INTEGER PRIMARY KEY autoincrement
        ,IDPersonas           /*2*/INTEGER NOT NULL
        ,NumeroMes            /*3*/INTEGER NOT NULL
        ,NumeroAnio           /*4*/INTEGER NOT NULL
        ,NumeroAtrasos        /*5*/INTEGER NOT NULL/*Entrada tarde*/
        ,NumeroSalidaAntes    /*6*/INTEGER NOT NULL/*Salida Antes*/
        ,HorasFaltantes       /*7*/INTEGER NOT NULL
        ,HorasExtra           /*8*/INTEGER NOT NULL
        ,HorasExtraOrdinarias /*9*/INTEGER NOT NULL
        ,DecimoTercerS       /*10*/VARCHAR(1) DEFAULT('M') CHECK (DecimoTercerS  IN ('A'/*Anual*/,'M'/*Mensual*/))
        ,DecimoCuartoS       /*11*/VARCHAR(1) DEFAULT('M') CHECK (DecimoCuartoS  IN ('A'/*Anual*/,'M'/*Mensual*/))
        ,NumeroHorasLaborables/*12*/INTEGER NOT NULL

        ,CONSTRAINT        fk_RegistroPersonas_RegistroMensual FOREIGN KEY (IDPersonas) REFERENCES RegistroPersonas(IDPersonas)
        UNIQUE (IDPersonas,NumeroMes,NumeroAnio)
    );


--DROP TABLE IF EXISTS Genero;
--DROP TABLE IF EXISTS PersonaTipo;
--DROP TABLE IF EXISTS MesesVacaciones;
--DROP TABLE IF EXISTS Horarios;

--CREATE TABLE Genero
--(
--    IDGenero           INTEGER PRIMARY KEY autoincrement
--    ,NombreGenero      VARCHAR(15) NOT NULL UNIQUE
--    ,Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
--    ,FechaCreacion     DATETIME DEFAULT (datetime('now', 'localtime'))
--    ,FechaModificacion DATETIME DEFAULT (datetime('now', 'localtime'))
--);

--CREATE TABLE PersonaTipo
--    (IDPersonaTipo     INTEGER PRIMARY KEY autoincrement
--    ,NombrePersonaTipo VARCHAR(15) NOT NULL UNIQUE
--    ,Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
--    ,FechaCreacion     DATETIME DEFAULT (datetime('now', 'localtime'))
--    ,FechaModificacion DATETIME DEFAULT (datetime('now', 'localtime')))
--;
--
--CREATE TABLE MesesVacaciones
--(
--    IDMesVacacion      INTEGER PRIMARY KEY autoincrement
--    ,NombreMes         VARCHAR(15) NOT NULL UNIQUE
--    ,Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
--    ,FechaCreacion     DATETIME DEFAULT (datetime('now', 'localtime'))
--    ,FechaModificacion DATETIME DEFAULT (datetime('now', 'localtime'))
--);
--
--CREATE TABLE Horarios
--(
--    IDHorario          INTEGER PRIMARY KEY autoincrement
--    ,Nombre            VARCHAR(15) NOT NULL UNIQUE
--    ,Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
--    ,FechaCreacion     DATETIME DEFAULT (datetime('now', 'localtime'))
--    ,FechaModificacion DATETIME DEFAULT (datetime('now', 'localtime'))
--);

/*
SELECT * FROM Genero WHERE (Estado='X') or (IDGenero=2)*/

