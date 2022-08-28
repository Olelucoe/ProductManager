package ru.netology;

public class ProductRepository {
    protected Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1]; // создаём массив который на единицу больше, чем предыдущий
        for (int i = 0; i < products.length; i++) { // копируем всё из старого массива
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product; // заполняем последнюю ячейку массива добавляемым товаром
        products = tmp; // заполняеем новый массив в качестве основного
    }
    public void removeById (int id) {
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

    public Product[] getProducts() {
        return products;
    }
}
