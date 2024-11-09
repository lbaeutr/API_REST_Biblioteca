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

    fun insert(autorNuevo : Autor): Autor? {

            // Logica de negocio

            /*
              1ero Por ejemplo, que la longitud de la biografia no sea mayor a 1000 caracteres
              2do que el anio de nacimiento no sea mayor al anio actual
              3 que el precio de los libros sea negativo
              4 que el anio de publicacion de los libors sea menor al anio de nacimiento del autor  y mayor al anio actual

             */

            if (autorNuevo.biografia.isNullOrEmpty() || autorNuevo.biografia!!.length>1000) {
                return null
            }

            //2do comunicarse con la capa de repository
          return  autorRepository.save(autorNuevo)
    }


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