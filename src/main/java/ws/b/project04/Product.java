/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.project04; // berfungsi untuk mengimport package yang ada di dalam project

/**
 *
 * @author priza // author
 */
public class Product { // berfungsi untuk membuat class dengan nama Product
    private String id; // berfungsi untuk membuat id dengan tipe data String
    private String name; // berfungsi untuk membuat name dengan tipe data String

    public String getId() { // berfungsi untuk membuat method getId
        return id; // berfungsi untuk mengembalikan nilai id
    } // berfungsi untuk menutup method getId
    public void setId(String id) { // berfungsi untuk membuat method setId
        this.id = id; // berfungsi untuk mengisi nilai id
    } // berfungsi untuk menutup method setId
    public String getName() { // berfungsi untuk membuat method getName
        return name; // berfungsi untuk mengembalikan nilai name
    } // berfungsi untuk menutup method getName
    public void setName(String name) { // berfungsi untuk membuat method setName
        this.name = name; // berfungsi untuk mengisi nilai name
    } // berfungsi untuk menutup method setName
} // berfungsi untuk menutup class Product
