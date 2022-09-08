package ru.netology.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;


public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product Smartphone = new Smartphone(111, "Redmi 11", 15999, "Xiaomi");
    Product Book = new Book(7, "Война и мир", 600, "Толстой Л.Н.");
    Product Smartphone2 = new Smartphone(33, "Galaxy S10", 24_500, "Samsung");
    Product Book2 = new Book(85, "Бойцовский клуб", 390, "Паланик Ч.");
    Product Smartphone3 = new Smartphone(12, "Galaxy S20", 39_500, "Samsung");
    Product Book3 = new Book(86, "Бойцовский клуб 2", 390, "Паланик Ч.");

    @Test
    public void shouldSearchProducts() {
        manager.add(Book);
        manager.add(Book2);
        manager.add(Book3);

        Product[] actual = manager.searchBy("клуб");
        Product[] expected = {Book2, Book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneProduct() {
        manager.add(Smartphone);
        manager.add(Smartphone2);
        manager.add(Smartphone3);

        Product[] actual = manager.searchBy("Redmi");
        Product[] expected = {Smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEmptyRepo() {

        Product[] actual = manager.searchBy("Redmi");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNonExistProduct() {
        manager.add(Book2);
        manager.add(Smartphone);
        manager.add(Smartphone2);
        manager.add(Book3);

        Product[] actual = manager.searchBy("IPhone");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showFindAll() {
        manager.add(Smartphone);
        manager.add(Smartphone2);
        manager.add(Smartphone3);
        manager.add(Book);
        manager.add(Book2);
        manager.add(Book3);

        Product[] expected = {Smartphone, Smartphone2, Smartphone3, Book, Book2, Book3};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}