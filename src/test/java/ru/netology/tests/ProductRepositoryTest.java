package ru.netology.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product Smartphone = new Smartphone(111, "Redmi 11", 15999, "Xiaomi");
    Product Book = new Book(7, "Война и мир", 600, "Толстой Л.Н.");
    Product Smartphone2 = new Smartphone(33, "Galaxy S10", 24_500, "Samsung");
    Product Book2 = new Book(85, "Бойцовский клуб", 390, "Паланик Ч.");

    @Test
    public void shouldAddProduct() {

        repo.addProduct(Smartphone);
        repo.addProduct(Smartphone2);
        repo.addProduct(Book);
        repo.addProduct(Book2);

        Product[] expected = {Smartphone, Smartphone2, Book, Book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveProductById() {
        repo.addProduct(Book2);
        repo.addProduct(Smartphone2);
        repo.addProduct(Book);
        repo.removeById(33);

        Product[] expected = {Book2, Book};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void showAllProducts(){

        Product[] expected = {};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFindById(){
        repo.addProduct(Smartphone);
        repo.addProduct(Smartphone2);
        repo.addProduct(Book);

        repo.removeById(111);

        Product[] expected = {Smartphone2, Book};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ThrowsNotFoundException() {
        repo.addProduct(Smartphone);
        repo.addProduct(Smartphone2);
        repo.addProduct(Book);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(333);});
    }
}
