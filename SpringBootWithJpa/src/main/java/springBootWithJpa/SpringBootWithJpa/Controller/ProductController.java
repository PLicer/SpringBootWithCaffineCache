package springBootWithJpa.SpringBootWithJpa.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springBootWithJpa.SpringBootWithJpa.Entity.Product;
import springBootWithJpa.SpringBootWithJpa.Service.ProdeuctService;

import java.security.Key;
import java.util.List;

@RestController
@RequestMapping("/api")
@CacheConfig(cacheNames = {"products"})

public class ProductController {


    @Autowired
    private ProdeuctService service;


    @PostMapping("/save")
    public Product Save(@RequestBody Product p)
    {
        return service.save(p);
    }

    @GetMapping("/get/{id}")
    @Cacheable(key = "#id")
    public Product get(@PathVariable int id)
    {
        return service.getByid(id);
    }

    @PutMapping("/put")
    @CachePut()
    public Product put(@RequestBody Product p)
    {
        return service.update(p);
    }

    @PostMapping("/saveall")
    public List<Product> Saveall(@RequestBody List<Product>p)
    {
        return service.saveall(p);
    }

    @GetMapping("/getAll")
    public List<Product>getAllProducts()
    {
        return service.getall();
    }

    @DeleteMapping("/deletebyid/{id}")
    @CacheEvict(key = "#id")
    public String deleteById(@PathVariable int id)
    {
        service.deleteByid(id);
        return "Deleted Successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllproducts()
    {
        service.deletAllProducts();
        return "Delete Successfully";
    }

    @GetMapping("/getcount")
    public long getcount()
    {
        return service.getcount();

    }

    @GetMapping("/isexist/{id}")
    public Boolean ifExist(@PathVariable int id)
    {
        return service.isExist(id);
    }

    @GetMapping("/getpricebetween")
    public List<Product> productsPriceBetween()
    {
        return service.priceBetween(200,2400);
    }

    @GetMapping("/Sort")
    public List<Product>sortData()
    {
        return service.sortAllProducts();
    }

}
