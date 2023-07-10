package pratice.applicationproduct.service;

import pratice.applicationproduct.model.Product;

import java.util.List;

public interface ProductService {
    void add (Product product);
    List<Product> List();
    Product findById(int id );
    void update (Product product);
    void delete (int id );
    Product findByName(String nameProduct);
}
