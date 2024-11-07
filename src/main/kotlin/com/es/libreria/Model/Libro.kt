package com.es.libreria.Model
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "libros")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var titulo: String,


    var genero: String,



    @Column(name = "anio_publicacion")
    var anioPublicacion: Int,


    var precio: Double,

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    var autor: Autor
)