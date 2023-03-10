package com.example.repository.impl;

import com.example.SessionUtil;
import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    public static List<Product> products;

    @Override
    public List<Product> listProductByName(String name) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where name like concat('%', :name, '%')")
                    .setParameter("name", name).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void createProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(product);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            Product p = findById(product.getId());
            p.setName(product.getName());
            p.setProducer(product.getProducer());
            p.setPrice(product.getPrice());
            p.setDescribe(product.getDescribe());
            session.update(p);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            Product product = findById(id);
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        products.remove(findById(id));
    }
}