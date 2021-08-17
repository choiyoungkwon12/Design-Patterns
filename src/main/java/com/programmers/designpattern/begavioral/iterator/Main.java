package com.programmers.designpattern.begavioral.iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf<Book> bookShelf = new BookShelf<>(4);
        bookShelf.appendBook(new Book("Java의 정석"));
        bookShelf.appendBook(new Book("토비의 스프링"));
        bookShelf.appendBook(new Book("팀 개발을 위한 git,github 시작하기"));
        bookShelf.appendBook(new Book("처음 배우는 스프링 부트2"));

        Iterator<Book> iterator = bookShelf.iterator();

        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println(book.getName());
        }
    }
}
