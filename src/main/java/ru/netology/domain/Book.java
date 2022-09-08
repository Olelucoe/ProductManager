package ru.netology.domain;

public class Book extends Product{

    public String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price); // супер - означает, что обращаемся к родительскому классу, добавляем аргументы в конструктор супер-класса
        this.author = author; // заполняем оставшееся поле
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
