Rick and Morty App
Este proyecto es una aplicación de Android basada en la API de Rick and Morty. Implementa Clean Architecture y MVVM, utilizando tecnologías modernas de Android como Jetpack Compose, Kotlin, Flow, Coroutines, Dagger Hilt y Room.

Tecnologías Utilizadas
Kotlin: Lenguaje principal del proyecto.

Jetpack Compose: Para la interfaz de usuario declarativa.

MVVM (Model-View-ViewModel): Arquitectura de presentación.

Clean Architecture: Separación de responsabilidades y modularidad.

Dagger Hilt: Inyección de dependencias.

Room Database: Para persistencia local de datos.

Retrofit + Moshi: Para la comunicación con la API de Rick and Morty.

Coroutines + Flow: Para la programación asíncrona.

Navigation Component: Para la navegación entre pantallas.

Características de la Aplicación
Lista de personajes de Rick and Morty obtenidos desde la API.

Pantalla de detalles de cada personaje.

Persistencia local para disponibilidad sin conexión.

Diseño adaptable con Jetpack Compose.

Estructura del Proyecto
com.mx.thtec.rickmotytest
├── app
│   ├── MainActivity.kt
│   ├── di (Módulo de inyección de dependencias)
│
├── data (Capa de datos)
│   ├── local (Base de datos Room)
│   ├── model (Modelos de datos)
│   ├── remote (Servicios de API)
│   ├── repository (Lógica de obtención de datos)
│
├── domain (Capa de dominio)
│   ├── model (Modelos de dominio)
│   ├── usecase (Casos de uso, opcional para futura expansión)
│
├── presentation (Capa de UI)
│   ├── ui (Vistas en Jetpack Compose)
│   ├── viewmodel (Lógica de UI con MVVM)
│
├── util (Constantes y utilidades)
Instalación y Configuración
Clonar el repositorio:

git clone https://github.com/Alan-Bp/rick-morty-app.git
Abrir el proyecto en Android Studio.

Compilar y ejecutar la aplicación en un dispositivo o emulador.

API Utilizada
La aplicación consume la API de Rick and Morty:

https://rickandmortyapi.com/api/character → Lista de personajes

https://rickandmortyapi.com/api/character/{id} → Detalle de un personaje

Capturas de Pantalla
![image](https://github.com/user-attachments/assets/527bf862-e51c-4af4-90fb-ed3f27756570)
![image](https://github.com/user-attachments/assets/3da2bd4a-23e1-4ea9-999e-a16350442686)

Contribuciones
Las contribuciones son bienvenidas. Si encuentras un error o quieres mejorar algo, abre un pull request.

