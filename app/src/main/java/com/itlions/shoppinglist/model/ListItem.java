package com.itlions.shoppinglist.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * TODO implement javadoc
 */
public class ListItem extends RealmObject {
    @PrimaryKey
    private int id;
    private int checked;
    private Product product;
    private ProductList productList;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
