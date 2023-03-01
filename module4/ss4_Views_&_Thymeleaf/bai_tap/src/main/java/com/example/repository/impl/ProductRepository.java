package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Thuoc cam", 20000, "Tri benh cam", "Nghia"));
        productList.add(new Product(2, "Thuoc sot", 25000, "Giam dau, ha sot", "Nghia"));
        productList.add(new Product(3, "Thuoc ho", 15000, "Tri benh ho", "Nghia"));
    }

    @Override
    public List<Product> display(String search) {
        List<Product> products = new ArrayList<>();
        if (search == null) {
            return productList;
        } else {
            for (Product product : productList) {
                if (product.getName().contains(search)) {
                    products.add(product);
                }
            }
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescribe(product.getDescribe());
                product1.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Product product = this.findById(id);
        if (product != null){
            productList.remove(product);
        }
    }
}
