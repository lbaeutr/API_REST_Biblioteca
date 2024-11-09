package com.es.libreria.Controller

import com.es.libreria.Model.Autor
import com.es.libreria.Service.AutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/autores") // http://localhost:8080/autores, cualquier petición que se haga a esta URL se va a manejar en este controlador
class AutorController {

    @Autowired // Inyección de dependencias de Spring Framework para que el controlador pueda acceder a los servicios
    private lateinit var autorServices :AutorService


    @PostMapping("/")
    fun insert(

        @RequestBody autornuevo: Autor
    ): Autor? {

        // Revisar la solicitud HTTP
        // Comprobar que lo que vieneo no es null
        // LLamar al Servicer

        if (autornuevo.nombre.isNullOrEmpty() || autornuevo.id != 0L) { // todo comprobar con el de diego
            return null
        }

        return autorServices.insert(autornuevo)

    }

    /*
    Responsabilidaddes
    Manejar las peticiones HTTP
     */

    // Consultar autores por ID

    @GetMapping("/{id}")// http://localhost:8080/autores/ la uri del metodo
    fun getByID(
        @PathVariable id: String
    ): Autor? {

        // 1ero Comprobacion Basica de los parametros.

        if (id.isNullOrEmpty()) {
            return null
        }

        //2do Comunico el co controller con el service
        return  autorServices.getById(id)


    }




}