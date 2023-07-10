package pratice.applicationproduct.service;

import pratice.applicationproduct.model.Product;

import java.util.*;

public class ProductServiceImlp implements ProductService {

      private  static Map<Integer,Product> myProducts = new HashMap<>();

      static {
          myProducts.put(1,new Product(1,"laptop1",250000,"ABCD","USA"));
          myProducts.put(2,new Product(2,"laptop2",250000,"EFGD","USA"));
          myProducts.put(3,new Product(3,"laptop3",250000,"UGFHT","USA"));
          myProducts.put(4,new Product(4,"laptop4",250000,"QWER","USA"));
          myProducts.put(5,new Product(5,"laptop5",250000,"ASDF","USA"));
      }
    @Override
    public void add(Product product) {
          myProducts.put(product.getId(), product);
    }

    @Override
    public List<Product> List() {
        return new ArrayList<>(myProducts.values());
    }

    @Override
    public Product findById(int id) {
          return myProducts.get(id);
    }

    @Override
    public void update(Product product) {
          myProducts.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
          myProducts.remove(id);

    }
    @Override
    public Product findByName(String nameProduct) {
        return null;
    }
}
