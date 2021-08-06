package com.programmers.designpattern.begavioral.iterator;

public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int Index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.Index = 0;
    }

    @Override
    public boolean hasNext() {
        if (Index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(Index);
        Index++;
        return book;
    }
}
