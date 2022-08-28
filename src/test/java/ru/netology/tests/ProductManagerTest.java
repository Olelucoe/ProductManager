package ru.netology.tests;

import org.junit.jupiter.api.Test;
import ru.netology.*;


public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product Smartphone = new Smartphone(111, "Redmi 11", 15999, "Xiaomi");
    Product Book = new Book(7, "Война и мир", 600, "Толстой Л.Н.");
    Product Smartphone2 = new Smartphone(33, "Galaxy S10", 24_500, "Samsung");
    Product Book2 = new Book(85, "Бойцовский клуб", 390, "Паланик Ч.");

    @Test
    public void shouldAllProducts() {
        Product[] products = {Smartphone, Book, Smartphone2, Book2};
    }

}