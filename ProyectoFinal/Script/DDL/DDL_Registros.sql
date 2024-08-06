-- database: ../../DataBase/RegistroEmpleado.sqlite
/*
CopyRight
autor: Jonathan Guaman
fecha: 23jul2024
description: Insertando Catalogos
*/
INSERT INTO CatalogoTipo
(NombreCatalogoTipo,Descripcion)VALUES
('Genero'          ,'Genero de la Persona (Masculino, Femenino, Otro)')
,('TipoPersona'    ,'Acceso Permitido o no a la base de datos (Empleado o Administrador)')
,('MesesVacaciones','Meses habiles para tomar las vacaciones'/*agosto,septiembre,octubre*/)
,('Horarios'       ,'Horarios habiles para tomar las vacaciones (manana y tarde)');

INSERT INTO Catalogo
(IDCatalogoTipo,NombreCatalogo,Descripcion)VALUES
(1              ,'Maculino'     ,'Genero de la persona') --1
,(1             ,'Femenino'     ,'Genero de la persona') --2
,(1             ,'Otro'         ,'Genero de la persona') --3

,(2             ,'Empleado'     ,'Tipos de persona') --4
,(2             ,'Administrador','Tipos de persona') --5

,(3             ,'Agosto'       ,'Mes para las vacaciones') --6
,(3             ,'Septiembre'   ,'Mes para las vacaciones') --7
,(3             ,'Octubre'      ,'Mes para las vacaciones') --8

,(4             ,'Manana'       ,'Horario disponible')  --9
,(4             ,'Tarde'        ,'Horario disponible'); --10

INSERT INTO RegistroPersonas
    (IDPersonas,IDPersonaTipo,Nombre    ,SegundoNombre,Apellido,SegundoApellido,Cedula    ,Edad,IDGenero,Correo                        ,Celular     ,Telefono ,PagoDecimoTercero,PagoDecimoCuarto,IDMesVacacion,IDHorario,Sueldo)VALUES
    (100909    ,5            ,'Jonathan','Steven'     ,'Guaman','Maza'         ,4789137890,20  ,1       ,'jonathan.guaman04@epn.edu.ec','0991593655','3118355','A'              ,'M'             ,6            ,10        ,1200)
;

INSERT INTO RegistroPersonas
    (IDPersonas,IDPersonaTipo,Nombre  ,SegundoNombre,Apellido   ,SegundoApellido,Cedula    ,Edad,IDGenero,Correo                       ,Celular     ,Telefono ,PagoDecimoTercero,PagoDecimoCuarto,Modificador,IDMesVacacion,IDHorario,Sueldo,FechaModificacion)VALUES
    (101809    ,5            ,'Nayeli','Anahi'      ,'Gualpa'   ,'Pena'         ,8746173578,20  ,2       ,'nayeli.gualpa@epn.edu.ec'   ,'0989481160','0256784','M'              ,'A'             ,100909     ,7            ,10       ,900   ,(datetime('now', 'localtime')))
    ,(105409   ,5            ,'Lizeth','Mayeli'     ,'Hernandez','Cusicagua'    ,8776177884,20  ,2       ,'lizeth.hernandez@epn.edu.ec','0982053643','0256784','M'              ,'A'             ,100909     ,7            ,10       ,900   ,(datetime('now', 'localtime')))
;

INSERT INTO RegistroPersonas
    (IDPersonas,IDPersonaTipo,Nombre  ,SegundoNombre,Apellido     ,SegundoApellido,Cedula    ,Edad,IDGenero,Correo                        ,Celular     ,Telefono ,PagoDecimoTercero,PagoDecimoCuarto,Modificador,IDMesVacacion,IDHorario,Sueldo,FechaModificacion             ,Estado)VALUES
    (102709    ,5            ,'Erick' ,'Mateo'      ,'Gualoto'    ,'Tanicuchi'    ,1036577891,20  ,1       ,'erick.gualoto04@epn.edu.ec'  ,'0981425150','1567849','A'              ,'A'             ,101809     ,8            ,9        ,750.60,(datetime('now', 'localtime')),'X')
    ,(103609   ,5            ,'David' ,'Fernando'   ,'Guanochanga','Pilicita'     ,1036977891,20  ,1       ,'david.guanochanga@epn.edu.ec','0992013765','1567849','M'              ,'A'             ,105409     ,8            ,9        ,750.60,(datetime('now', 'localtime')),'X')
    ,(104509   ,5            ,'Jhojan','Sebastian'  ,'Zambrano'   ,'Curicho'      ,1036477891,20  ,1       ,'jhojan.zambrano@epn.edu.ec'  ,'0992557559','1567849','M'              ,'M'             ,105409     ,8            ,9        ,750.60,(datetime('now', 'localtime')),'X')
;

-- Insertar festividades y su descripcion
INSERT INTO Festividades (descripcion) 
VALUES  ("New year"),                       --1
        ("Carnaval"),                       --2
        ("Viernes Santo"),                  --3
        ("Dia del Trabajador"),             --4
        ("Batalla de Pichincha"),           --5
        ("Primer Grito de Independencia"),  --6
        ("Independencia de Guayaquill"),    --7
        ("Dia de los difuntos"),            --8
        ("Independencia de Cuenca"),        --9
        ("Navidad");                        --10

--Insertar las fechas de las festividades
INSERT INTO DiasFestivos (festividad_id, numero_mes, numero_dia )
VALUES  (1, 1, 1),       -- New year (Lunes)
        (2, 2, 12),       -- Carnaval (Lunes)
        (2, 2, 13),       -- Carnaval (Martes)
        (3, 3, 29),       -- Viernes Santo (Viernes)
        (4, 5, 3),        -- Dia del Trabajador (Viernes)
        (5, 5, 24),       -- Batalla de Pichincha (Viernes)
        (6, 5, 9),        -- Primer Grito de Independencia (Viernes)
        (7, 10, 11),      -- Independencia de Guayaquill (Viernes)
        (8, 11, 1),       -- Dia de los difuntos (Viernes)
        (9, 11, 4),       -- Independencia de Cuenca (Lunes)
        (10, 12, 25);     -- Navidad (Miercoles)

INSERT INTO RegistroMensual
(IDPersonas    ,NumeroMes  ,NumeroAnio   ,NumeroAtrasos ,NumeroSalidaAntes   ,HorasFaltantes    ,HorasExtra ,HorasExtraOrdinarias    ,DecimoTercerS  ,DecimoCuartoS    ,NumeroHorasLaborables)VALUES
(100909        ,1          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,2          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,3          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,4          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,5          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,6          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,7          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8),
(100909        ,8          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"A"            ,"M"              ,8)
;
INSERT INTO RegistroMensual
(IDPersonas    ,NumeroMes  ,NumeroAnio   ,NumeroAtrasos ,NumeroSalidaAntes   ,HorasFaltantes    ,HorasExtra ,HorasExtraOrdinarias    ,DecimoTercerS  ,DecimoCuartoS    ,NumeroHorasLaborables)VALUES
(101809        ,1          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,2          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,3          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,4          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,5          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,6          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,7          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8),
(101809        ,8          ,2024         ,5             ,1                   ,5                 ,6          ,6                       ,"M"            ,"A"              ,8)
;


--INSERT INTO RegistroDiario
--(
--IDPersonas,HoraEntrada,MinutoEntrada,HoraSalida,MinutoSalida,NumeroDia,NumeroMes,NumeroAnio,EstadoEnt)VALUES
--(100909   ,7          ,0            ,16        ,01          ,2        ,1        ,2024      ,'I');

--SELECT * FROM RegistroPersonas;
--
--SELECT Nombre ,SegundoNombre ,Apellido ,SegundoApellido ,Cedula ,Edad ,IDGenero ,Correo ,Celular ,Telefono ,Estado ,PagoDecimoTercero ,PagoDecimoCuarto ,IDMesVacacion ,IDHorario ,Sueldo
--    FROM RegistroPersonas
--    WHERE IDPersonas = 100909 AND EXISTS
--    (SELECT * FROM RegistroPersonas WHERE Estado = 'A' AND IDPersonas = 104509) ;
--
--SELECT * 
--        FROM RegistroPersonas 
--        WHERE IDPersonas = 100909 AND Estado = 'A';
--
--INSERT INTO Genero
--    (NombreGenero) VALUES
--    ('Masculino'),
--    ('Femenino'),
--    ('Otro'),
--    ('Trans'),
--    ('Bigenero')
--;
--INSERT INTO MesesVacaciones
--    (NombreMes)VALUES
--    ('Agosto'),
--    ('Septiembre'),
--    ('Octubre')
--;
--INSERT INTO Horarios
--    (Nombre)VALUES
--    ('Manana'),
--    ('Tarde')
--;
--UPDATE Genero
--    SET Estado = 'X',
--    FechaModificacion = datetime('now', 'localtime')
--    WHERE IDGenero = 4
--;
--UPDATE Genero
--    SET Estado = 'X',
--    FechaModificacion = datetime('now', 'localtime')
--    WHERE IDGenero = 5
--;
--INSERT INTO PersonaTipo
--    (NombrePersonaTipo) VALUES
--    ('Administrador'),
--    ('Empleado')
--;
