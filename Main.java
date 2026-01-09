package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static ru.netology.AddRemoveBasket.*;
import static ru.netology.Filter.filterProduct;

public class Main {

    static Map<Product, Integer> products = new HashMap<>();
    public static final String currency = "руб.";

    public static void main(String[] args) {
        Basket basket = new Basket(new HashMap<>(), products);

        products.put(new Product("Хлеб белый", 60), 10);
        products.put(new Product("Хлеб черный", 50), 10);
        products.put(new Product("Молоко", 100), 10);
        products.put(new Product("Гречка", 80), 10);
        products.put(new Product("Орехи грецкие", 250), 10);
        products.put(new Product("Орехи бразильские", 350), 10);

        DataProducts dataProducts = new DataProducts(products);

        shouListProduct();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - отфильтровать");
            System.out.println("2 - добавить в корзину");
            System.out.println("3 - удалить из корзины");
            System.out.println("4 - показать корзину");
            System.out.println("5 -завершить покупку");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    filterProduct();
                    break;
                case "2":
                    addProductBacket(basket);
                    break;
                case "3":
                    removeProductBacket(basket);
                    break;
                case "4":
                    printProductBasket(basket);
                    break;
                case "5":
                    endBuyProduct(basket);
                    break;
                default:
                    System.out.println("Такой команды нет!");

            }
        }
    }
    static void shouListProduct() {
        System.out.println("Список доступных продуктов в магазине: ");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            String nameList = String.format("наименование: %s, цена: %d, количество: %d ", product.getName(), product.getPrice(), entry.getValue());
            System.out.println(nameList);
        }
    }
    static void printAllProduct() {
        shouListProduct();
    }
}




