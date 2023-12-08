# Online Election

## Descripción
Online Election es una aplicación de votación en línea que utiliza Java para el backend y React con Vite para el frontend.

## Estructura del Proyecto
El proyecto está organizado en dos partes principales: backend y frontend.

### Backend
La parte del servidor de la aplicación está construida con Java y utiliza Spring Boot. Aquí se gestionan las operaciones relacionadas con la lógica de negocio, la seguridad (Spring Security con JSON Web Token), y la conexión a una base de datos MySQL ubicada en la carpeta `database`.

### Frontend
El frontend de la aplicación está construido con React y Vite. Proporciona una interfaz de usuario interactiva para que los usuarios participen en la votación en línea.

## Requisitos Previos
Asegúrate de tener instalados los siguientes requisitos previos en tu sistema antes de comenzar:

- Java Development Kit (JDK)
- Node.js y npm (Node Package Manager)

## Configuración y Ejecución

### Frontend
1. Navega a la carpeta `frontend` del proyecto.
2. Ejecuta el comando para construir y ejecutar el frontend:
   ```bash
   ./npm install  # instalar dependencias
   ./npm run dev  # iniciar frontend

### Backend
1. Navega a la carpeta `backend` del proyecto (donde se encuentra el archivo `pom.xml`).
2. Ejecuta el siguiente comando para construir y ejecutar el backend usando Maven:

   ```bash
   mvn spring-boot:run