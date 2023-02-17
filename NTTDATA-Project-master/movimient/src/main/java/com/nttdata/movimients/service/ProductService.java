package com.nttdata.movimients.service;

import java.util.List;

import com.nttdata.movimients.model.Product;

public interface ProductService {

    /**
     * list all banking products
     * return – returns a list of bank products
     */
    List<Product> getProduct();

    /**
     * save bank products
     *
     * @param product – save product data
     * @return – returns bank product
     */

    boolean saveProduct(Product product);


    /**
     * update banking product
     *
     * @param product – update product data
     * @return – returns data from the updated banking product
     */
    Product updateProduct(Product product);

    /**
     * search products by id
     *
     * @param id – search product by id
     * @return – returns bank product id
     */

    Product getProductById(long id);

    /**
     * remove banking product
     *
     * @param id – remove product data
     */
    void deleteProduct(long id);

}
