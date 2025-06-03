# PROYECTO-GIT-TERCER-TRIMESTRE
Daniel Garcia, Daniel Chaves, Roberto Casasola y Javier Garcia


# Entornos - Registro de Entradas Personales

Este proyecto es una aplicación de consola en Java pensada para gestionar registros personales diarios. Cada usuario puede guardar y visualizar información sobre su aprendizaje, tareas realizadas, dificultades y herramientas utilizadas.

## Funcionalidades

- Registro e inicio de sesión de usuarios.
- Creación de entradas con información personalizada.
- Almacenamiento y lectura de datos usando archivos `.obj`.
- Visualización de entradas previas filtradas por usuario.

## Estructura del Proyecto

- `src/`: Contiene el código fuente principal.
  - `Lanzador.java`: Clase principal que inicia la aplicación.
  - `Entrada.java`: Clase que representa cada entrada de usuario.
  - `Usuario.java`: Clase que gestiona la información del usuario.
  - `Lecturas/`: Contiene utilidades como lectores de entrada por consola.
- `bin/`: Archivos compilados.
- `Entradas.obj` y `Usuarios.obj`: Archivos que almacenan los datos serializados.