# Product API - Spring Boot

Backend API sederhana untuk mengelola data produk menggunakan Spring Boot. Project ini dibuat berdasarkan Modul Praktikum Fullstack Enterprise Application Integration.

---

## 👥 Disusun Oleh (Kelompok 7)

- Alfredo Radhinal Mukhtar - 235150201111021  
- Nailah Ansaria - 235150201111009  
- Muhammad Bagas Anugrah - 235150201111008  
- Irmalia Dwi Kautsar - 235150200111013  

---

## 🚀 Deskripsi Project

Aplikasi ini merupakan backend REST API yang digunakan untuk mengelola data produk. Backend ini mampu menerima request dari client, memproses data, dan memberikan response dalam format JSON. Data produk disimpan menggunakan database H2 (in-memory database) yang berjalan selama aplikasi aktif.

---

## 🛠️ Teknologi yang Digunakan

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 Database  
- Maven  
- Thunder Client (Testing API)
  
---

---

## 🌐 Base URL

http://localhost:8080

---

## 📌 Endpoint API

GET    /api/products  
GET    /api/products/{id}  
POST   /api/products  
PUT    /api/products/{id}  
DELETE /api/products/{id}  

---

## 📥 Contoh Request & Response

POST /api/products

### Request
{
  "name": "Laptop",
  "price": 15000000,
  "stock": 5
}

### Response
{
  "id": 1,
  "name": "Laptop",
  "price": 15000000,
  "stock": 5
}

## ⚠️ Validasi Data
- Nama produk tidak boleh kosong
- Harga harus lebih besar dari 0
- Stok tidak boleh negatif

## ▶️ Cara Menjalankan Project
mvn spring-boot:run

## 🧪 Testing API
Testing menggunakan Thunder Client untuk GET, POST, PUT, dan DELETE.

## 📊 Database
Menggunakan H2 Database (in-memory).
Data akan hilang saat aplikasi dihentikan.

## ✅ Kesimpulan
Backend API berhasil dibangun menggunakan Spring Boot dan seluruh endpoint CRUD berjalan dengan baik.
