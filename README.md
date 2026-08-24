# Sistema de Gestión de Inventario de Herramientas
**INTECSA IND S.A.C.**

Sistema web desarrollado con Spring Boot para gestionar el inventario 
de herramientas del área de almacén, con control de stock, 
movimientos y reportes exportables en PDF y Excel.

---

## Tecnologías

| Capa | Tecnología |
|------|-----------|
| Lenguaje | Java 17 |
| Framework | Spring Boot 4.0.6 |
| Persistencia | Spring Data JPA + Hibernate |
| Seguridad | Spring Security + BCrypt |
| Vistas | Thymeleaf + Bootstrap 5 |
| Base de datos | MySQL |
| Reportes | Apache POI (Excel) + iText (PDF) |
| Build | Maven |
| Versionamiento | Git + GitHub |

---

## Funcionalidades

- Login con roles (Admin / Almacenero)
- CRUD completo de herramientas
- Registro de entradas y salidas de stock
- Actualización automática de stock transaccional
- Alertas de stock crítico
- Dashboard con estadísticas en tiempo real
- Búsqueda y filtrado de herramientas
- Reportes exportables en PDF y Excel

---

## Roles del sistema

| Rol | Acceso |
|-----|--------|
| ADMIN | Dashboard, CRUD herramientas, gestión usuarios, reportes |
| USER (Almacenero) | Ver inventario, registrar movimientos, historial |

---

## Base de datos

MySQL — script en `/database/database.sql`

El script incluye:
- Creación de la base de datos `inventario_db`
- Creación de tablas: `usuarios`, `herramientas`, `movimientos`
- 62 herramientas de prueba pre-cargadas

---

## Configuración e instalación

### 1. Clonar el repositorio
```bash
git clone https://github.com/diazm005/inventory-management-intecsa.git
cd inventory-management-intecsa
```

### 2. Crear la base de datos
Ejecutar el script en MySQL Workbench:

database/database.sql


### 3. Configurar credenciales
Crear el archivo `src/main/resources/application.properties` 
basándose en `application.properties.example`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventario_db?createDatabaseIfNotExist=true
spring.datasource.username=TU_USUARIO_MYSQL
spring.datasource.password=TU_PASSWORD_MYSQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.thymeleaf.cache=false
server.port=8080
spring.application.name=inventario
```

### 4. Ejecutar el proyecto
```bash
mvn spring-boot:run
```

### 5. Acceder al sistema

http://localhost:8080/login


---

## Usuario por defecto

| Usuario | Contraseña | Rol |
|---------|-----------|-----|
| admin | admin123 | ADMIN |

El usuario admin se crea automáticamente al iniciar la aplicación.

---

## Autor

Martin Diaz — Estudiante de Informática, CIBERTEC

Operario en INTECSA IND S.A.C.

Proyecto academico desarrollado e implementado en entorno real de trabajo.
