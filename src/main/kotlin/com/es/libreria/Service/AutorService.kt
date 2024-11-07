package com.es.libreria.Service

import com.es.libreria.Model.Autor
import com.es.libreria.Repository.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class AutorService {

    @Autowired
    private lateinit var autorRepository: AutorRepository

    /*
    Responsabilidaddes del
    Controlar la logica de Negocio
    Comunicarse con la capa de datos
     */

    fun getById(id: String): Autor? {

        // 1ero implementar logica de negocio

        var idl : Long = 0
        try {

            idl = id.toLong()

        }catch (e: Exception){
                e.printStackTrace()
            return null
        }


        //2do comunicarse con la capa de repository
        val autor : Autor? = autorRepository. findByIdOrNull(idl)


        return autor

    }
}