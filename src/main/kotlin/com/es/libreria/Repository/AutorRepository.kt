package com.es.libreria.Repository

import com.es.libreria.Model.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {


}