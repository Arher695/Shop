package ru.netology;

import java.util.Scanner;

public class Main {
    public static final String currency = "руб.";

    public static void main(String[] args) {

        //Вывод доступных для покупки товаров

        System.out.println("Список доступных для покупки товаров:");
        String[] product = {"Хлеб (1 бул.)", "Молоко (1 л.)", "Гречка (1 кг.)", "Орехи (200 гр.)"};
        int[] pricesProduct = {60, 100, 80, 250};
        for (int i = 0; i < product.length; i++) {
            System.out.println(product[i] + " - " + pricesProduct[i] + " руб.");
        }

        /*//Фильтрация товаров по ключевым словам, ценам, производителям

        System.out.println("Выберете фильтр товаров:");
        String[] filterProduct = {"0 - выход", "1 - по ключевому слову", "2 - по цене ", "3 - по производителю"};
        System.out.println(Arrays.toString(filterProduct));*/

        //Составление продуктовой корзины пользователя
        Scanner scanner = new Scanner(System.in);
        int[] basket = new int[product.length];
        int totalAmount = 0;
        while (true) {
            System.out.println("Ведите номер продукта и его количество: ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length < 2) {
                System.out.println("Вы ввели данные не полностью! ");
            } else if (Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) > product.length) {
                int productIndex = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);
                basket[productIndex] += productCount;
                totalAmount += pricesProduct[productIndex] * productCount;

            } else {
                System.out.println("Продукта под таким номером нет!");
            }
        }
        System.out.println("Список продуктов: ");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] > 0) {
                System.out.println(product[i] + " " + basket[i] + " " + pricesProduct[i] + " " + currency);
            }
        }
        System.out.println("Общая сумма: " + totalAmount);
    }

    //Трекинг заказа в системе доставки
    //Возврат заказа, повторение заказа
    //Система рейтинга для товаров
    //Простая рекомендательная система для покупок
}
