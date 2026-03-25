# Product API - Spring Boot Source
Source ini mengikuti Modul Praktikum Fullstack Enterprise Application Integration untuk backend Product API.

## Disusun Oleh: Kelompok 7
- Alfredo Radhinal Mukhtar - 235150201111021
- Nailah Ansaria - 235150201111009
- Muhammad Bagas Anugrah - 235150201111008
- Irmalia Dwi Kautsar - 235150200111013

## Fitur
- Entity `Product`
- Repository JPA
- Service layer
- REST Controller
- Validasi request
- Exception handler global
- Endpoint CRUD: GET all, GET by id, POST, PUT, DELETE
- H2 database
- Unit test controller, service, repository

## Struktur Endpoint
- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

## Cara Menjalankan di Laptop/IDE
1. Pastikan Java 17+ dan Maven terpasang.
2. Masuk ke folder project.
3. Jalankan:
   ```bash
   mvn spring-boot:run
   ```
4. Atau buka project di IntelliJ IDEA / VS Code lalu jalankan `ProductApiApplication`.

## Menjalankan Test
```bash
mvn test
```

## Catatan
Environment pembuatan artefak ini tidak menyediakan Maven dan dependency resolver eksternal,
sehingga bukti running pada laporan menggunakan folder `product-api-runtime-demo` yang memiliki
kontrak endpoint yang sama untuk demonstrasi lokal.
