# 📌 HexagonalJava - Gestión de Clientes y Productos

## ✨ Descripción
HexagonalJava es un sistema basado en la **arquitectura hexagonal**, diseñado para gestionar clientes y productos de manera eficiente utilizando **Java y MySQL**.
El proyecto sigue los principios de **clean architecture**, permitiendo flexibilidad y escalabilidad.

## 🚀 Tecnologías Utilizadas
🔹 **Java 17** - Lenguaje principal del proyecto.  
🔹 **MySQL** - Base de datos relacional.  
🔹 **Maven** - Gestión de dependencias.  
🔹 **JDBC** - Conexión con la base de datos.  
🔹 **Singleton Pattern** - Gestión centralizada de configuración.  
🔹 **Arquitectura Hexagonal** - Separación de lógica de negocio e infraestructura.  

## 📥 Instalación y Configuración
### 📌 Requisitos previos
🔹 Tener **Java 17** o superior instalado.  
🔹 Tener **MySQL** en ejecución con una base de datos configurada.  
🔹 Tener **Maven** instalado para gestionar dependencias.  

### 📥 Clonar el repositorio
```bash
git clone https://github.com/mariaHelenaSalas/HexagonalJava.git
cd HexagonalJava
```

### 🛠 Configurar la base de datos en MySQL
1. **Abrir MySQL y crear la base de datos**:
```sql
CREATE DATABASE hexagonal_java;
USE hexagonal_java;
```

2. **Crear la tabla `cliente`**:
```sql
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

3. **Crear la tabla `producto`**:
```sql
CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL
);
```

4. **Verificar que las tablas se crearon correctamente**:
```sql
SHOW TABLES;
```

### 🛠 Configurar el archivo `config.properties`
Ubicado en `src/main/resources/config.properties`:
```properties
db.url=jdbc:mysql://localhost:3306/hexagonal_java
db.user=root
db.password=1234
```

### 🚀 Ejecutar el proyecto
1. **Compilar y ejecutar con Maven**:
```bash
mvn clean install
mvn exec:java
```

2. **También puedes ejecutar directamente desde tu IDE (IntelliJ, Eclipse, VS Code).**

## 📂 Estructura del Proyecto
```
📁 HexagonalJava/
├── 📁 src/main/java/com/hexagonaljava/
│   ├── 📂 domain/entity/        # Entidades (Client, Product)
│   ├── 📂 application/usecase/  # Casos de uso (ClientUseCase, ProductUseCase)
│   ├── 📂 domain/repository/    # Interfaces de repositorio
│   ├── 📂 infrastructure/
│   │   ├── database/            # Conexión con la base de datos (ConnMySql, ConnectionFactory)
│   │   ├── persistence/         # Implementaciones de repositorio
│   ├── 📄 Main.java             # Punto de entrada del programa
```

## 🖥️ Funcionalidades
✅ **Gestión de Clientes:** Registrar, listar y actualizar clientes.  
✅ **Gestión de Productos:** Registrar y listar productos.  
✅ **Conexión con MySQL:** Uso de JDBC para manejar la base de datos.  
✅ **Patrón Singleton:** Para la configuración de la conexión.  

## 👩‍💻 Autora
**Maria Helena Salas**  
📌 [GitHub Profile](https://github.com/mariaHelenaSalas)  
📩 **Email:** _mariahelenasalas83@gmail.com_  

🚀 ¡Gracias por visitar el proyecto! Si tienes dudas o sugerencias, estaré encantada de mejorar el código. 😊

