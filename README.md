# Gestión de Productos API

> API para la gestión de productos, incluyendo operaciones CRUD, paginación, eliminación lógica y manejo de documentos relacionados de manera desacoplada.

![Version](https://img.shields.io/badge/versión-1.0.0-blue?style=flat-square) ![Framework](https://img.shields.io/badge/framework-Spring%20WebFlux-green?style=flat-square)

## Información del Proyecto

| Campo | Valor |
|---|---|
| **Nombre** | Gestión de Productos API |
| **Versión OpenAPI** | `1.0.0` |
| **Framework** | Spring WebFlux |
| **Group** | `com.example` |
| **Artifact** | `gesti-n-de-productos-api` |
| **Package** | `com.example.gestindeproductosapi` |

## Endpoints

### Products

| Método | Path | Descripción |
|--------|------|-------------|
| `POST` | `/products` | Crear un nuevo producto |
| `GET` | `/products` | Listar productos con paginación |
| `GET` | `/products/{id}` | Obtener detalle de un producto por ID |
| `DELETE` | `/products/{id}` | Eliminar producto (soft delete) |

## Configuración y Ejecución

**Requisitos:** Java 17+, Gradle 8+

```bash
./gradlew build
./gradlew bootRun
```

- API: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

---

> Generado con **Mock API** · 15 de marzo de 2026