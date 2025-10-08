
# 🚀 SpringBoot + Spring Security + JWT (Token Bearer)

SpringBoot + Spring Security + JWT (Token Bearer)
Este proyecto es una demostración / plantilla para implementar autenticación y autorización basada en JWT (JSON Web Tokens) con Spring Boot y Spring Security.

---

## 🛠️ Tecnologías utilizadas
- **Java 17** → Lenguaje principal  
- **Spring Boot 3.3.7** → Framework  
- **Maven** → Gestión de dependencias  
- **JWT** (io.jsonwebtoken / libreria jjwt)
- **Postman** → Pruebas de endpoints
- **IntelliJ IDEA** → IDE Desarrollo
- **MySQL** → Motor de Base de datos

---


## 🚀 Características

- Registro / inicio de sesión de usuarios
- Generación de JWT al autenticar
- Validación de JWT en cada solicitud protegida
- Protección de endpoints según roles/permisos


## 📂 Estructura del proyecto
```bash

──demoJwt
    ├───.mvn
    │   └───wrapper
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───autenticacion
    │   │   │           ├───Auth
    │   │   │           ├───config
    │   │   │           ├───demo
    │   │   │           ├───Jwt
    │   │   │           └───User
    │   │   └───resources
    │   └───test
    │       └───java
    │           └───com
    │               └───autenticacion
    │                   └───demoJwt



```
---

## ⚙️ Instalación y ejecución
### 🔹 Requisitos previos

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)


## 🔹 Pasos

1. Clonar

 - git clone https://github.com/omarpedraza1979/springboot-security-jwt

2. Compilar y ejecutar
 - .. \springboot-security-jwt\demoJwt>  mvn spring-boot:run


3. La API quedará disponible en:  
 - http://localhost:8080

---

## 📌 Endpoints principales

| Método | Endpoint        | Descripción                  | Comentario                                                     |
|--------|-----------------|------------------------------|----------------------------------------------------------------|
| POST   | `/auth/register`| Registro inicial de usuario  | enviar datos usuario → devuelve un JWT                         |
| POST   | `/auth/login`   | Login usuario registrado     | enviar credenciales (usuario / contraseña) → devuelve un JWT   | 
| POST   | `/api/v1/demo`  | URL protegida por token      | petición GET/POST con encabezado Authorization: Bearer <token> | 


## 🧪 Ejemplo con CURL

1. Registro de usuario : 

 curl -X POST http://localhost:8080/auth/register \
     -H "Content-Type: application/json" \
     -d '{
             "username": "oscar",
             "password": "oscar123",
             "lastName": "gzon",
             "firstName": "car",
             "country": "Ecdor"
         }'
  

2. Login usuario registrado :


3. URL protegida por token :






## 🧪 Postman
Este proyecto incluye una colección de Postman para probar los endpoints de la API. 
[SpringBootJWToken.postman_collection.json](./SpringBootJWToken.postman_collection.json)


---
## 🧪 Pruebas
```bash
mvn test
```
---

## 👨‍💻 Autor
- **Omar Orlando Pedraza Garzón**
- [GitHub](https://github.com/omarpedraza1979)
---


## 📜 Licencia
Este proyecto está bajo la licencia [MIT](LICENSE).  
Eres libre de usarlo, modificarlo y distribuirlo con fines personales o educativos.


