package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class ProductRepository {
    protected Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1]; // создаём массив который на единицу больше, чем предыдущий
        for (int i = 0; i < products.length; i++) { // копируем всё из старого массива
            tmp[i] = products[i]; // в новый массив
        }
        tmp[tmp.length - 1] = product; // заполняем последнюю ячейку массива добавляемым товаром
        products = tmp; // заполняем новый массив в качестве основного
    }
    public void removeById (int id) {
        if (findById(id) == null) { // если товара с таким id нет, то --
            throw new NotFoundException("Нет товара с таким id для удаления: " + id); // создаём такое исключение
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) { // если id товара совпадает с искомым
                return product; // то возвращаем его
            }
        }
        return null;
    }
    public Product[] getProducts() {
        return products;
    }

}
