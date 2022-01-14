package com.valts.RestJerseyDemo.controllers;

import com.valts.RestJerseyDemo.models.Book;
import com.valts.RestJerseyDemo.services.BookService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BookController {
    private BookService bookService = new BookService();

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Path("/")
    public String linktree() {
        return "Use /books";
    }

    @GET
    @Path("/books")
    @Produces("application/json")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @POST
    @Path("/books")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Book book) {
        bookService.add(book);
        return Response.created(URI.create("/books/" + book.getName())).build();
    }

    @PUT
    @Path("/books/{name}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("name") String name, Book book) {
        bookService.update(name, book);
        return Response.created(URI.create("/books/" + name)).build();
    }

    @DELETE
    @Path("/books/{name}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("name") String name) {
        bookService.delete(name);
        return Response.ok().build();

    }

}
