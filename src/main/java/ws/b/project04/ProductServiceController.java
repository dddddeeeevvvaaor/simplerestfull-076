/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.project04; // package name

import java.util.HashMap; // berfungsi untuk mengimport class HashMap
import java.util.Map; // berfungsi untuk mengimport class Map

import org.springframework.http.HttpStatus; // berfungsi untuk mengimport class HttpStatus
import org.springframework.http.ResponseEntity; // berfungsi untuk mengimport class ResponseEntity
import org.springframework.web.bind.annotation.PathVariable; // berfungsi untuk mengimport class PathVariable
import org.springframework.web.bind.annotation.RequestBody; // berfungsi untuk mengimport class RequestBody
import org.springframework.web.bind.annotation.RequestMapping; // berfungsi untuk mengimport class RequestMapping
import org.springframework.web.bind.annotation.RequestMethod; // berfungsi untuk mengimport class RequestMethod
import org.springframework.web.bind.annotation.RestController; // berfungsi untuk mengimport class RestController

/**
 *
 * @author priza // author
 */
@RestController // berfungsi untuk mengatur class sebagai controller
public class ProductServiceController { // class ProductServiceController
    private static Map<String, Product> productRepo = new HashMap<>(); // berfungsi untuk mendeklarasikan variable productRepo dengan tipe data Map dan menginisialisasikan variable tersebut dengan HashMap

    static { // berfungsi untuk menginisialisasi variable productRepo
        Product honey = new Product(); // berfungsi untuk mendeklarasikan variable honey dengan tipe data Product dan menginisialisasikan variable tersebut dengan Product
        honey.setId("1"); // berfungsi untuk mengatur id dari variable honey
        honey.setName("Honey"); // berfungsi untuk mengatur name dari variable honey
        productRepo.put(honey.getId(), honey); // berfungsi untuk mengatur productRepo dengan mengisi id dan name dari variable honey

        Product almond = new Product(); // berfungsi untuk mendeklarasikan variable almond dengan tipe data Product dan menginisialisasikan variable tersebut dengan Product
        almond.setId("2"); // berfungsi untuk mengatur id dari variable almond
        almond.setName("Almond"); // berfungsi untuk mengatur name dari variable almond
        productRepo.put(almond.getId(), almond); // berfungsi untuk mengatur productRepo dengan mengisi id dan name dari variable almond
    } // berfungsi untuk mengakhiri method static

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE) // berfungsi untuk mengatur request mapping dengan mengatur value dan method
    public ResponseEntity<Object> delete(@PathVariable("id") String id) { // berfungsi untuk mendeklarasikan variable delete dengan tipe data ResponseEntity dan menginisialisasikan variable tersebut dengan Object
        if (!productRepo.containsKey(id)) // berfungsi untuk mengatur kondisi jika productRepo tidak mengandung id
            return new ResponseEntity<>("No Product found for ID " + id, HttpStatus.NOT_FOUND); // berfungsi untuk mengembalikan nilai dari ResponseEntity
        productRepo.remove(id); // berfungsi untuk menghapus id dari productRepo
        return new ResponseEntity<>("Product is deleted successsfully ID " + id, HttpStatus.OK); // berfungsi untuk mengembalikan nilai dari ResponseEntity
    } // berfungsi untuk menutup method delete

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT) // berfungsi untuk mengatur request mapping dengan mengatur value dan method
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { // berfungsi untuk mendeklarasikan variable updateProduct dengan tipe data ResponseEntity dan menginisialisasikan variable tersebut dengan Object
        if (!productRepo.containsKey(id)) { // berfungsi untuk mengatur kondisi jika productRepo tidak mengandung id
            return new ResponseEntity<>("Product is not found ID " + id, HttpStatus.NOT_FOUND); // berfungsi untuk mengembalikan nilai dari ResponseEntity
        } // berfungsi untuk mengakhiri kondisi
        productRepo.remove(id); // berfungsi untuk menghapus id dari productRepo
        product.setId(id); // berfungsi untuk mengatur id dari variable product
        productRepo.put(id, product); // berfungsi untuk mengatur productRepo dengan mengisi id dan name dari variable product
        return new ResponseEntity<>("Product is updated successsfully ID " + id, HttpStatus.OK); // berfungsi untuk mengembalikan nilai dari ResponseEntity
    } // berfungsi untuk menutup method updateProduct

    @RequestMapping(value = "/products", method = RequestMethod.POST) // berfungsi untuk mengatur request mapping dengan mengatur value dan method
    public ResponseEntity<Object> createProduct(@RequestBody Product product) { // berfungsi untuk mendeklarasikan variable createProduct dengan tipe data ResponseEntity dan menginisialisasikan variable tersebut dengan Object
        if (productRepo.containsKey(product.getId())) { // berfungsi untuk mengatur kondisi jika productRepo mengandung id
            return new ResponseEntity<>("Product is already exist ID " + product.getId(), HttpStatus.NOT_FOUND); // berfungsi untuk mengembalikan nilai dari ResponseEntity
        } // berfungsi untuk mengakhiri kondisi
        productRepo.put(product.getId(), product); // berfungsi untuk mengatur productRepo dengan mengisi id dan name dari variable product
        return new ResponseEntity<>("Product is created successfully" + " ID : " + product.getId() + " Product : " + product.getName(), HttpStatus.CREATED); // berfungsi untuk mengembalikan nilai dari ResponseEntity
    } // berfungsi untuk menutup method createProduct

    @RequestMapping(value = "/products") // berfungsi untuk mengatur request mapping dengan mengatur value
    public ResponseEntity<Object> getProduct() { // berfungsi untuk mendeklarasikan variable getProduct dengan tipe data ResponseEntity dan menginisialisasikan variable tersebut dengan Object
        if (productRepo.isEmpty()) { // berfungsi untuk mengatur kondisi jika productRepo kosong
            return new ResponseEntity<>("Product is not found", HttpStatus.NOT_FOUND); // berfungsi untuk mengembalikan nilai dari ResponseEntity
        } // berfungsi untuk mengakhiri kondisi
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK); // berfungsi untuk mengembalikan nilai dari ResponseEntity
    } // berfungsi untuk menutup method getProduct
} // berfungsi untuk menutup class ProductServiceController