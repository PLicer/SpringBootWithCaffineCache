package springBootWithJpa.SpringBootWithJpa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springBootWithJpa.SpringBootWithJpa.Entity.Product;
import springBootWithJpa.SpringBootWithJpa.Repository.ProductRepository;

import java.util.List;

@Service
public class ProdeuctService {



    @Autowired
    private ProductRepository repository;
    public Product save(Product p) {

        return repository.save(p);


    }

    public Product getByid(int id) {
           return repository.findById(id).orElse(null);

    }
    public Product update(Product p) {
        Product product = repository.findById(p.getId()).orElse(null);

        if (product != null) {
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            product.setDescription(p.getDescription());
            product.setSku(p.getSku());
            repository.save(product);

            return product;
        }
        return null;
    }

    public List<Product> saveall(List<Product> p) {

        return repository.saveAll(p);


    }


    public List<Product> getall() {
        return repository.findAll();
    }

    public void deleteByid(int id) {
        repository.deleteById(id);
    }

    public void deletAllProducts() {
        repository.deleteAll();
    }

    public long getcount() {
        return repository.count();
    }

    public Boolean isExist(int id) {
        return repository.existsById(id);
    }

    public List<Product> priceBetween(int i, int i1) {
        return repository.findByPriceBetween(i,i1);
    }

    public List<Product> sortAllProducts() {
        String sortBy="name";
        String sortDesc="description";
        String sortDir="desc";
        Sort sortByName=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Sort sortByDescription=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortDesc).ascending():Sort.by(sortDesc).descending();
        Sort groupBySort=sortByName.and(sortByDescription);
        List<Product>list=repository.findAll(groupBySort);
        return list;
    }
}
