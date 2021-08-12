package com.programmers.designpattern.begavioral.iterator;

public class BookShelfIterator<T> implements Iterator {

    private BookShelf<T> bookShelf;
    private int Index;

    public BookShelfIterator(BookShelf<T> bookShelf) {
        this.bookShelf = bookShelf;
        this.Index = 0;
    }

    @Override
    public boolean hasNext() {
        return Index < bookShelf.getLength();
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(Index);
        Index++;
        return book;
    }
}
