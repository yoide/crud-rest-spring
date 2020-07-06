package springprojects.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springprojects.springcrud.entities.Auto;
import springprojects.springcrud.service.IAutoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AutoController {
    @Autowired
    public IAutoService autoService;

    @PostMapping("/autos")
    public ResponseEntity<Auto> crearAuto(@RequestBody Auto auto){  // El metodo va a retornar un ResponseEntity de tipo auto y recibe a traves del body de la peticion http un objeto de tipo auto
        return new ResponseEntity(this.autoService.save(auto), HttpStatus.CREATED);  //crea un objeto ResponseEntity con 2 parametros: el objeto y el codigo de estado de la respuesta.

    }

    @GetMapping("/autos/{id}")
    public ResponseEntity<Auto> obtenerAuto(@PathVariable("id") Long id){
        Optional<Auto> optionalAuto = autoService.getAuto(id);
        if(optionalAuto.isPresent()){
            return new ResponseEntity(optionalAuto.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/autos/{id}/nuevoprecio/{precio}")
    public ResponseEntity<Auto> actualizarAuto(@PathVariable("id") Long id, @PathVariable("precio") double precio){
        Auto autoActualizado = this.autoService.update(id, precio);
        if(autoActualizado != null){
            return new ResponseEntity(autoActualizado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/autos/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable("id") Long id){
        this.autoService.delete(id);
        return ResponseEntity.noContent().build();  // noContent es un metodo de http q el codigo de estatus es mapeado a un valor 204 que significa que se realiz'o la operaci'on y no se devolvio contenido
                                                      // deberia implementar las excepciones
    }


}
