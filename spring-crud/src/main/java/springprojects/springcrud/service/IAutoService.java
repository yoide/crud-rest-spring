package springprojects.springcrud.service;

import springprojects.springcrud.entities.Auto;

import java.util.Optional;

public interface IAutoService {
    Auto save(Auto auto);
    Optional<Auto>  getAuto(Long id);        //Se utiliza el tipo de objeto opcional de JAVA xq puede ser que el objeto que vayamos a buscar no esté
    Auto update(Long id, double nuevoPrecio);
    boolean delete(long id);

}
