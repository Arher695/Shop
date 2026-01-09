package ru.netology;

import java.util.Map;
import java.util.Scanner;

import static ru.netology.Main.products;

public class AddRemoveBasket {

    static void endBuyProduct(Basket basket) {
        basket.buyProductTotalAmount();
    }

    static void printProductBasket(Basket basket) {
        basket.printBasket();
    }

    static void removeProductBacket(Basket basket) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Напишите наименование продукта  и его количество, который нужно удалить, через запятую: ");
            System.out.println("Для выхода наберите утв или end");
            String input = scanner.nextLine();
            if ("end".equals(input) || "утв".equals(input)) {
                break;
            }

            String[] parts = input.split(",");
            String nameProduct = parts[0].toLowerCase();
            boolean isRemoveProduct = false;
            Integer removeCount = parts.length > 1 ? Integer.parseInt(parts[1].trim()) : Integer.MAX_VALUE;
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                if (nameProduct.equals(entry.getKey().getName().toLowerCase())) {
                    products = basket.removeProduct(entry.getKey(), removeCount);
                    System.out.println("Продукт удален");
                    isRemoveProduct = true;
                    break;
                }
            }
            if (!isRemoveProduct) {
                System.out.printf("Продукт %s не удалён, такого продукта нет\n", parts[0]);
            }
        }
    }

    static void addProductBacket(Basket basket) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Напишите наименование продукта и его количество через запятую: ");
            System.out.println("Для выхода наберите утв или end");
            String input = scanner.nextLine();
            if ("end".equals(input) || "утв".equals(input)) {
                break;
            }

            String[] parts = input.split(",");
            String nameProduct = parts[0].toLowerCase();
            boolean isAddProduct = false;
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                if (nameProduct.equals(entry.getKey().getName().toLowerCase())) {
                    products = basket.addProduct(entry.getKey(), Integer.parseInt(parts[1].trim()));
                    System.out.println("Продукт добавлен");
                    isAddProduct = true;
                    break;
                }
            }
            if (!isAddProduct) {
                System.out.printf("Продукт %s отсутствует\n", parts[0]);
            }
        }
    }
}
