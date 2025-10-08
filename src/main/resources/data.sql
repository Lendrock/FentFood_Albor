INSERT IGNORE INTO Productos (nombre_producto, descripcion, unidad_medida, fecha_vencimiento, estado_producto) VALUES
('Arroz Fortificado 10 lb', 'Bolsa 10 lb de arroz fortificado', 'bolsa', '2026-04-15', 'vigente'),
('Leche Líquida 1 L', 'Botella 1 L leche pasteurizada', 'l', '2025-12-01', 'almacenado'),
('Aceite Vegetal 1 L', 'Botella 1 L aceite comestible', 'l', '2026-03-01', 'almacenado'),
('Huevos Frescos (docena)', 'Caja con 12 huevos frescos', 'docena', '2025-10-20', 'vigente'),
('Harina de Trigo 1 kg', 'Paquete 1 kg harina de trigo', 'kg', '2026-06-30', 'almacenado');

INSERT IGNORE INTO Usuarios (nombre, correo, psw, rol) VALUES
('Carlos Ramírez', 'carlos.ramirez@gmail.com', '123456', 'GESTOR'),
('Ana González', 'ana.gonzalez@gmail.com', 'abcdef', 'GESTOR'),
('Luis Martínez', 'luis.martinez@gmail.com', 'luis123', 'GESTOR'),
('María López', 'maria.lopez@gmail.com', 'maria321', 'GESTOR'),
('Miguel Sánchez', 'miguel.sanchez@gmail.com', 'miguel555', 'GESTOR'),
('Jack Torres', 'jack.torres@gmail.com', 'jack123', 'DONADOR'),
('Laura Méndez', 'laura.mendez@gmail.com', 'laura456', 'DONADOR'),
('Sofía Ruiz', 'sofia.ruiz@gmail.com', 'sofia789', 'SUPERVISOR');

INSERT IGNORE INTO Gestores (id_usuario, nombre_Gestor, apellido_Gestor, telefono, direccion) VALUES
(1, 'Carlos', 'Ramírez', '5555-1234', 'Zona 1, Ciudad de Guatemala'),
(2, 'Ana', 'González', '5555-5678', 'Zona 2, Antigua Guatemala'),
(3, 'Luis', 'Martínez', '5555-9999', 'Zona 10, Quetzaltenango'),
(4, 'María', 'López', '5555-8888', 'Zona 18, Chimaltenango'),
(5, 'Miguel', 'Sánchez', '5555-4321', 'Zona 5, Guatemala');


