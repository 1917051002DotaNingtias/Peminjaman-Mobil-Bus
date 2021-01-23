# Nama Anggota Kelompok
1. 1917051001/Imam Akbar
2. 1917051002/Dota Ningtias
3. 1917051003/Anisa Nadila Lase

# 🚌 Peminjaman Mobil Bus
> Sistem dapat digunakan untuk melakukan peminjaman mobil bus, dimana mobil dapat dipinjam oleh individual atau instansi.
> Dalam satu kali transaksi hanya dapat meminjam satu mobil.

📚 Libraries and Tools of this project:
- mysql-connector-java-5.1.xx.jar
- sqlite-jdbc-3.xx.jar
- scene builder
- sqlite studio
- mysql server (xampp recomended)
- netbean editor
- VS Code installed plugin
    - Markdown All in one
    - Markdown preview
    - Live Server

## 🖌️ Desain
To view the diagrams below install mermaid-diagram plugin at https://github.com/Redisrupt/mermaid-diagrams

### Class Diagram
```mermaid
classDiagram
    Peminjaman <|-- Individu
    Peminjaman <|-- Instansi

    class Peminjaman{
        <<abstract>>
        #int IdPeminjaman
        #String tanggal
        #String NomorKendaraan
        #String NamaPenyewa
        #int LamaPeminjaman
        #int BiayaPeminjaman
        +int nextIdPeminjaman()
    }

    class Individu{
        -String Pekerjaan
    }

    class Instansi{
        -String BidangInstansi
    }
```

### ER Diagram
```mermaid
erDiagram
    Peminjaman ||..|| Individu : is
    Peminjaman ||..|| Instansi : is
    Peminjaman{
        int IdPeminjaman
        String tanggal
        String NomorKendaraan
        String NamaPenyewa
        int LamaPeminjaman
        int BiayaPeminjaman
    }
    Individu{
        String Pekerjaan
    }
    Instansi{
        String BidangInstansi
    }
```

### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Peminjaman <|-- Individu
    Peminjaman <|-- Instansi
    Peminjaman o-- PeminjamanDataModel : Data Modeling
    PeminjamanDataModel <-- PeminjamanController : Data Control
    PeminjamanDataModel --> DBHelper : DB Connection
    PeminjamanController <.. FormPeminjaman : Form Control

    class Peminjaman{
        <<abstract>>
        #int IdPeminjaman
        #String tanggal
        #String NomorKendaraan
        #String NamaPenyewa
        #int LamaPeminjaman
        #int BiayaPeminjaman
        +int nextIdPeminjaman()
    }

    class Individu{
        -String Pekerjaan
    }

    class Instansi{
        -String BidangInstansi
    }

    class PeminjamanDataModel{
        Connection conn
        addPeminjaman()
        getIndividu()
        getInstansi()
        NextIDPeminjaman()
    }

    class PeminjamanController{
        initialize()
        handleButtonAddPeminjamanIndividu()
        handelButtonAddPeminjamanInstansi()
        loadDataIndividu()
        loadDataInstansi()
        handleClearForm()
    }

    class DBHelper{
        String Username
        String Password
        String DB
        getConnection()
        getConnection(String driver)
        createTable()
    }
```
