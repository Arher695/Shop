package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static ru.netology.Main.*;


public class Filter {
    static void filterProduct() {
        System.out.println("Выберете фильтр товаров:");
        System.out.println("0 - выход, 1 - по ключевому слову, 2 - по цене ");
        Scanner scanner = new Scanner(System.in);
        boolean needFilter = true;
        while (needFilter) {
            String input = scanner.nextLine();
            switch (input) {
                case "0":
                    printAllProduct();
                    needFilter = false;
                    break;
                case "1":
                    System.out.println("Введите ключевое слово:");
                    String keyWord = scanner.nextLine();
                    printFilterProductByKeyWord(keyWord);
                    needFilter = false;
                    break;
                case "2":
                    System.out.println("Введите цену:");
                    String keyPrice = scanner.nextLine();
                    printFilterProductByKeyPrice(keyPrice);
                    needFilter = false;
                    break;
                default:
                    System.out.println("Такой команды нет!");
            }
        }
    }

    private static void printFilterProductByKeyPrice(String keyPrice) {
        Map<Product, Integer> filterPrice = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer keyPriceInt = Integer.parseInt(keyPrice);
            if (product.getPrice().equals(keyPriceInt)) {
                filterPrice.put(product, entry.getValue());
            }
        }
        for (Map.Entry<Product, Integer> entry : filterPrice.entrySet()) {
            Product product = entry.getKey();
            String nameList = String.format("наименование: %s, цена: %d, количество: %d ", product.getName(), product.getPrice(), entry.getValue());
            System.out.println(nameList);
        }
    }


    private static void printFilterProductByKeyWord(String keyWord) {
        Map<Product, Integer> filterProduct = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product.getName().toLowerCase().contains(keyWord.toLowerCase())) {
                filterProduct.put(product, entry.getValue());
            }
        }
        for (Map.Entry<Product, Integer> entry : filterProduct.entrySet()) {
            Product product = entry.getKey();
            String nameList = String.format("наименование: %s, цена: %d %s, количество: %d ", product.getName(), product.getPrice(), currency, entry.getValue());
            System.out.println(nameList);
        }
    }

}
