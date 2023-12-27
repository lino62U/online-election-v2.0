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


   # Proyecto Online Election v2.0

Este repositorio contiene el código fuente y los scripts necesarios para construir, analizar y probar la aplicación Online Election v2.0. A continuación, se presenta un resumen del pipeline utilizado para llevar a cabo estas acciones.

## Requisitos previos

Asegúrese de tener instaladas las siguientes herramientas en su entorno de desarrollo:

- [Maven](https://maven.apache.org/) (v3.9.4)
- [Apache JMeter](https://jmeter.apache.org/) (v5.6.2)
- [Python](https://www.python.org/) (para ejecutar pruebas funcionales)

Además, se debe configurar un servidor SonarQube con la URL y token de autenticación correspondientes.

## Pipeline de CI/CD

El pipeline definido en Jenkins realiza diversas etapas, desde la clonación del repositorio hasta las pruebas de rendimiento. A continuación, se describen cada una de las etapas del pipeline:

### 1. **Clonación del repositorio**
   - Se realiza la clonación del repositorio desde la rama principal.

### 2. **Construcción del backend**
   - Utilizando Maven, se limpian los artefactos anteriores y se construye el backend de la aplicación.

### 3. **Análisis de SonarQube**
   - Se ejecuta un análisis estático del código fuente utilizando SonarQube.
   - La información clave, como el proyecto, la URL de SonarQube y el token de autenticación, se configuran como variables de entorno.

### 4. **Pruebas unitarias**
   - Se ejecutan las pruebas unitarias del backend mediante el comando `mvn test`.

### 5. **Pruebas funcionales**
   - Se cambia al directorio de pruebas y se ejecutan las pruebas funcionales escritas en Python utilizando el comando `python -m unittest discover`.

### 6. **Pruebas de rendimiento**
   - Se ejecutan pruebas de rendimiento utilizando Apache JMeter.
   - El archivo de prueba se encuentra en la carpeta `performance-test/PruebaOnline.jmx`, y los resultados se guardan en `result.jtl`.

## Configuración del entorno

Asegúrese de configurar las siguientes variables de entorno antes de ejecutar el pipeline:

```groovy
M2_HOME = 'C:\\Program Files\\Maven\\apache-maven-3.9.4'
JMETER_HOME = 'D:\\A-UNSA\\IS_2\\LAB_06\\apache-jmeter-5.6.2'
PATH = "${JMETER_HOME}/bin:${PATH};${M2_HOME}/bin:${PATH}"

SONAR_URL = 'http://localhost:9000' // Reemplazar con la URL de su servidor SonarQube
SONAR_LOGIN = 'sqp_012a34c0113ddfc2165b0c1d827380452b228cd5' // Reemplazar con su token de autenticación de SonarQube
```

¡Ahora está listo para ejecutar el pipeline y contribuir al desarrollo del proyecto Online Election v2.0!
## Pruebas de Funcionalidad
![SonarQube](img/1.jpg)
![Issues](img/2.jpg)
![Login](img/3.jpg)
![Voto](img/4.jpg)
