drop database if exists DB_FentFood;
create database DB_FentFood;
use DB_FentFood;
-- INDEPENDIENTES --
create table Usuarios(
	idUsuario int auto_increment,
    nombreUsuario varchar(100),
    correo varchar(100),
    contrasena varchar(255),
    rol enum('gestor', 'donador', 'supervisor') not null,
    
    constraint pk_Usuarios primary key (idUsuario)
);

create table Productos (
	idProducto int auto_increment,
    nombreProducto varchar(64),
    descripcion varchar(64) not null,
    unidadMedida enum('unidad', 'pieza', 'paquete', 'bolsa', 'kg', 'g', 'l', 'ml', 'docena', 'caja') not null,
    fechaVencimiento date, 
    estadoProducto enum('vigente','vencido','entregado', 'descartado', 'almacenado') default 'almacenado',
    
    constraint pk_Productos primary key(idProducto)
);

create table Beneficiarios(
	idBeneficiario int auto_increment,
    nombreBeneficiario varchar(64),
    apellidoBeneficiario varchar(64),
    telefono varchar(20),
    direccion varchar(255),
    tipoBeneficiario enum('familia', 'institucion') not null,
    necesidad varchar(64),
    
    constraint pk_Beneficiarios primary key (idBeneficiario)
);

-- DEPENDIENTES -- 
create table Gestores(
	idGestor int auto_increment,
    idUsuario int not null,
    nombreGestor varchar(64) not null,
    apellidoGestor varchar(64) not null,
    telefono varchar(20) not null,
    direccion varchar(255) not null,
    
    constraint pk_Gestores primary key(idGestor),
    
    constraint fk_Gestores_Usuarios foreign key(idUsuario)
		references Usuarios(idUsuario)
);

create table Donadores(
	idDonador int auto_increment,
    idUsuario int,
    nombreDonador varchar(64),
    apellidoDonador varchar(64),
    telefono varchar(64),
    direccion varchar(255),
    tipoDonador enum('empresa', 'persona') not null,
    
    constraint pk_Donadores primary key (idDonador),
    
    constraint fk_Donadores_Usuarios foreign key (idUsuario)
		references Usuarios(idUsuario)
);

create table Donaciones(
	idDonacion int auto_increment,
    idDonador int not null,
    fechaDonacion datetime default current_timestamp,
    metodoEntrega enum('presencial','recoleccion') not null,
    observaciones varchar(64),
    
    constraint pk_Donaciones primary key(idDonacion),
    
    constraint fk_Donaciones_Donadores foreign key(idDonador)
		references Donadores(idDonador)

);

create table DetalleDonaciones(
	idDetalleDonacion int auto_increment,
    idDonacion int not null,
    idProducto int not null,
    cantidad decimal(10,2) not null,
    
    constraint pk_DetalleDonaciones primary key (idDetalleDonacion),
    
    constraint fk_DetalleDonaciones_Donaciones foreign key (idDonacion)
		references Donaciones(idDonacion),
	constraint fk_DetalleDonaciones_Productos foreign key (idProducto)
		references Productos(idProducto)
);

create table Entregas(
	idEntrega int auto_increment,
    idBeneficiario int not null,
    idGestor int not null,
    fechaEntrega datetime default current_timestamp,
    observaciones varchar(255),
    
    constraint pk_Entregas primary key (idEntrega),
    
    constraint fk_Entregas_Beneficiarios foreign key (idBeneficiario)
		references Beneficiarios(idBeneficiario),
	constraint fk_Entregas_Gestores foreign key (idGestor)
		references Gestores(idGestor)
);

create table DetalleEntregas(
	idDetalleEntrega int auto_increment,
    idEntrega int not null,
    idProducto int not null,
    cantidad decimal(10,2) not null,
    estado enum('en_proceso','Entregado','Cancelado') not null,
    
    constraint pk_DetalleEntregas primary key(idDetalleEntrega),
    
    constraint fk_DetalleEntregas_Entregas foreign key (idEntrega)
		references Entregas(idEntrega),
	constraint fk_DetalleEntregas_Productos foreign key (idProducto)
		references Productos(idProducto)
);

create table Inventarios(
	idInventario int auto_increment,
    idProducto int not null,
    stock decimal(10, 2),
    fechaActualizacion datetime default current_timestamp,
    
    constraint pk_Inventarios primary key (idInventario),
    
    constraint fk_Inventarios_Productos foreign key(idProducto)
		references Productos(idProducto)
);
