package ru.netology;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.Main.shouListProduct;


public class Basket {
    private Map<Product, Integer> basketProduct;
    private Map<Product, Integer> dataProducts;

    public Basket(Map<Product, Integer> basketProduct, Map<Product, Integer> dataProducts) {
        this.basketProduct = basketProduct;
        this.dataProducts = dataProducts;
    }

    public Map<Product, Integer> getBasketProduct() {
        return basketProduct;
    }

    public void setBasketProduct(Map<Product, Integer> basketProduct) {
        this.basketProduct = basketProduct;
    }

    public Map<Product, Integer> addProduct(Product product, Integer count) {
        if (basketProduct == null) {
            basketProduct = new HashMap<>();
        }

        Integer currentCount = count > dataProducts.get(product) ? dataProducts.get(product) : count;
        basketProduct.put(product, currentCount);
        dataProducts.put(product, dataProducts.get(product) - currentCount);
        return dataProducts;
    }

    public Map<Product, Integer> removeProduct(Product product, Integer count) {
        if (basketProduct != null) {
            boolean removeAllProduct = basketProduct.get(product) > count ? false : true;
            basketProduct.get(product);
            if (removeAllProduct) {
                dataProducts.put(product, dataProducts.get(product) + basketProduct.get(product));
                basketProduct.remove(product);
            } else {
                dataProducts.put(product, dataProducts.get(product) + count);
                basketProduct.put(product, basketProduct.get(product) - count);
            }
        }

        return dataProducts;
    }

    public void printBasket() {
        if (basketProduct == null) {
            System.out.println("В корзине ничего нет");
        } else {
            System.out.println("Список продуктов в корзине: ");
            for (Map.Entry<Product, Integer> entry : basketProduct.entrySet()) {
                Product product = entry.getKey();
                Integer totalAmount = product.getPrice() * entry.getValue();
                String nameList = String.format("наименование: %s, сумма: %d, количество: %d ", product.getName(), product.getPrice() * entry.getValue(), entry.getValue());
                System.out.println(nameList);
            }
        }
    }

    public void buyProductTotalAmount() {
        if (basketProduct == null) {
            System.out.println("Вы еще ничего не выбрали. Корзина пустая!");
        } else {
            System.out.println("Вы купили: ");
            for (Map.Entry<Product, Integer> entry : basketProduct.entrySet()) {
                Product product = entry.getKey();
                String nameList = String.format("наименование: %s, сумма: %d, количество: %d ", product.getName(), product.getPrice() * entry.getValue(), entry.getValue());
                System.out.println(nameList);
                basketProduct.clear();
                shouListProduct();
            }
        }
    }
}
