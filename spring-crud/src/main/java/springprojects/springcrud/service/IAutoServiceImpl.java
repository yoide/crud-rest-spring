package springprojects.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.springcrud.entities.Auto;
import springprojects.springcrud.repository.AutoRepository;

import java.util.Optional;

@Service
public class IAutoServiceImpl implements IAutoService {
    @Autowired
    private AutoRepository repo;


    @Override
    public Auto save(Auto auto) {
        return this.repo.save(auto);
    }

    @Override
    public Optional<Auto> getAuto(Long id) {
        return this.repo.findById(id);
    }

    @Override
    public Auto update(Long id, double nuevoPrecio) {
        Optional<Auto> autoOptional = this.repo.findById(id);
        if(autoOptional.isPresent()){
            Auto temp = autoOptional.get();
            temp.setPrecio(nuevoPrecio);
            return save(temp);
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
      this.repo.deleteById(id);
      return true;
    }
}
