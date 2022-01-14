package com.valts.RestJerseyDemo.services;

import com.valts.RestJerseyDemo.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> fakeDatabase = new ArrayList<>();



    //    get
    public List<Book> getAll() {
        return fakeDatabase.stream().toList();
    }

//    add
    public void add(Book book) {
        fakeDatabase.add(book);
    }

//    update
    public void update(String name, Book book) {
        fakeDatabase.forEach(x -> {
            if (x.getName().equalsIgnoreCase(name)) {
                fakeDatabase.set(x.getIndex(), book);
                return;
            }
        });

    }
//    delete
    public void delete(String name) {
        var bookOptional = fakeDatabase.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
        Book book = bookOptional.get();
        fakeDatabase.remove(book);
    }
}
