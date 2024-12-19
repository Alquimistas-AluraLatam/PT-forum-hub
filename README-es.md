# Foro Hub - Challenge Back-end del Programa ONE

## Descripción del proyecto

Foro Hub es una implementación de una API REST utilizando Java y Spring, donde la aplicación es un foro común con tópicos y respuestas relacionadas con cursos.

Este proyecto replica de manera simplificada el foro disponible en la plataforma de Alura, utilizado durante el estudio de cursos.

Nos enfocamos en los tópicos del foro, específicamente en la creación, consulta, actualización y eliminación de temas, es decir, el famoso CRUD (*Create, Read, Update, Delete*) en proyectos *backend*.

### Curso del desafío

Para más información sobre Foro Hub, accede al [curso del desafío](https://app.aluracursos.com/course/spring-framework-challenge-foro-hub), que también incluye el tablero de Trello del desafío.

## Estructura del proyecto

El proyecto se centra en la implementación de entidades relacionadas con tópicos, respuestas, cursos y usuarios, replicando un foro típico asociado con cursos o tecnologías. Esta aplicación es una construcción de una API REST con funcionalidades vistas en la formación de Java y Spring Boot.

También trabajamos con la persistencia de datos en una base de datos relacional MySQL, utilizando migraciones (*migrations*) y la dependencia Flyway para la creación de tablas.

Además, gestionamos la seguridad de la aplicación implementando autenticación de usuarios, permitiendo solo a usuarios autorizados crear temas, responder a ellos o crear cursos.

Finalmente, documentamos la API de Fórum Hub utilizando Swagger y la dependencia SpringDoc.

## Tecnologías utilizadas

- **Java** - versión 17: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- **Maven** - versión 4.0.0
- **Spring** - versión 3.2.5: https://start.spring.io/
- **MySQL** - versión 8.0: https://dev.mysql.com/downloads/
- **IntelliJ Community (opcional):** https://www.jetbrains.com/idea/download/?section=windows

### Dependencias de Spring utilizadas:

- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

## Persistencia de Datos

Usando *migrations*, solo es necesario crear la base de datos antes de ejecutar el proyecto. Las migraciones construyen las tablas y generan datos iniciales.

Todo el código SQL relevante para el proyecto debe ejecutarse mediante *migrations*, permitiendo a los desarrolladores mantener un historial de cambios en la persistencia de datos.

## Autenticación de Usuarios

El proyecto utiliza Spring Security para gestionar la seguridad y autenticación de la aplicación, junto con JWT para generar tokens de autenticación.

Para probar el proyecto, se deben autenticar usuarios presentes en la base de datos. **Se recomienda insertar previamente usuarios con contraseñas encriptadas** antes de ejecutar el proyecto y realizar la autenticación con el token generado.

## Cómo ejecutar el proyecto

Para ejecutar este proyecto localmente, se debe crear un archivo .jar del proyecto Java. Los pasos básicos son:

### **Usando la Línea de Comando (javac y jar)**

1. **Compilar el código:** Navega hasta el directorio donde está tu código fuente y compila los archivos .java a .class:

```bash
javac -d out src/com/tuProyecto/*.java
```

1. **Crear el archivo JAR:**

```bash
jar cvf miProyecto.jar -C out .
```

### **Usando Eclipse**

1. Exportar como JAR:
   - Haz clic derecho en el proyecto en **Project Explorer**.
   - Selecciona **Export** y luego **Java > JAR file**.
   - Elige los recursos a exportar y la ubicación para guardar el archivo JAR.
   - Configura las opciones de exportación y haz clic en **Finish**.

### **Usando IntelliJ IDEA**

1. **Crear artefacto:**
   - Ve a **File > Project Structure**.
   - En la pestaña **Artifacts**, haz clic en **+** y selecciona **JAR > From modules with dependencies**.
   - Selecciona el módulo principal del proyecto y configura las opciones necesarias.
   - Haz clic en **OK** y luego en **Apply**.
2. **Construir artefacto:**
   - Ve a **Build > Build Artifacts** y selecciona el artefacto creado.
   - Haz clic en **Build** para generar el archivo JAR.

También es posible utilizar herramientas de construcción como **Maven** y **Gradle** para crear el archivo .jar.

## Autores

- Instructor Eric Monné: https://www.linkedin.com/in/ericmonnefo/
- Monitora Brenda Souza: https://www.linkedin.com/in/breudes/
