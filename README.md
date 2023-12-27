# Online Election

## Descripción
Online Election es una aplicación de votación en línea que utiliza Java para el backend y React con Vite para el frontend.

## Propósito del proyecto
El propósito de este proyecto es implementar un proceso de Integración Continua y Despliegue Continuo (CI/CD) para el desarrollo y evolución de una aplicación web de software. Este enfoque tiene como objetivo principal mejorar la calidad del software, facilitar la colaboración entre desarrolladores y acelerar el ciclo de vida de desarrollo.

Aquí hay algunos aspectos clave del propósito de este proyecto:

1. Automatización del Desarrollo y Despliegue: La implementación de un pipeline de CI/CD implica automatizar tareas como compilación, pruebas, análisis estático de código, y despliegue. Esto reduce errores humanos, acelera el tiempo de desarrollo y garantiza la consistencia en los entornos de desarrollo, prueba y producción.

2. Mejora de la Calidad del Código: Se menciona que el proyecto elegido es relativamente complejo y poco estructurado, con bugs, code smells y vulnerabilidades. El propósito es limpiar y mejorar la calidad del código mediante la identificación y corrección de estos problemas. La implementación de prácticas como Domain-driven Design (DDD), estilos y convenciones de codificación, codificación limpia (Clean Code) y principios SOLID contribuirá a este objetivo.

3. Colaboración Efectiva: El uso de GitHub y la estrategia de trabajo con branches para realizar cambios individuales antes de la fusión facilita una colaboración más efectiva entre los miembros del equipo de desarrollo. Esto permite un desarrollo más estructurado y evita conflictos frecuentes al trabajar en el mismo código.

4. Mejora en la Seguridad: La eliminación de vulnerabilidades mencionadas implica fortalecer la seguridad de la aplicación web. Un proceso de CI/CD bien implementado puede incluir análisis de seguridad automatizado para detectar y corregir posibles problemas de seguridad de manera proactiva.

5. Adopción de Buenas Prácticas: La implementación de patrones y estilos de arquitectura, así como la adopción de prácticas de desarrollo de software, como DDD, contribuye a la construcción de un código más mantenible, escalable y robusto.

En resumen, el propósito de este proyecto es transformar una aplicación web existente, que presenta problemas de calidad y estructuración, en un sistema más robusto, seguro y mantenible mediante la implementación de un pipeline de CI/CD y la adopción de buenas prácticas de desarrollo de software.


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
