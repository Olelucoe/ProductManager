package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.addProduct(product);
    }

    public Product[] findAll() {
        return repo.getProducts();
    }

    public Product[] searchBy(String text) { // метод поиска по названию( принимает текст по которому надо искать)
       Product[] result = new Product[0]; // создаём новый массив, изначально он пустой,в нём будем хранить подошедшие запросу продукты

        for (Product product : repo.getProducts()) { // циклом перебираем товары в репозитории
            if (matches(product, text)) { // проверяем подходит ли товар с помощью метода matches(!)
                Product[] tmp = new Product[result.length + 1]; // и ещё один массив на единицу больше, чем Product
                for (int i = 0; i < result.length; i++) { // копируем всё из result
                 tmp[i] = result[i]; // копируем всё из result
                }
                 tmp[tmp.length-1] = product;// "добавляем в конец" массива result продукт product
                result = tmp; // запоминаем текущий массив в качестве результата
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) { // метод оределяет подходит ли товар по условию поиска
        if (product.getName().contains(search)) {  //contains это метод Java, позволяющий проверить, содержит ли String
                                                  // другую подстроку или нет
            return true; // если название товара содержит нужное нам слово, то возвращаем true
        } else {
            return false;
        }
    }
}
