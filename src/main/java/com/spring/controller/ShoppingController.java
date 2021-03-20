package com.spring.controller;

import com.spring.database.ShoppingDatabase;
import com.spring.model.entity.Shopping;
import com.spring.model.request.ShoppingRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingDatabase shoppingDatabase;

    @ApiOperation("Request to get a shoppingList element by it's name.")
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shopping> getElement(
            @RequestParam(value = "list name", defaultValue = "Standardliste") String listName,
            @RequestParam(value = "product name", defaultValue = "Apfel") String productName) {

        return ResponseEntity.ok(shoppingDatabase.getElement(listName, productName));
    }

    @ApiOperation("Request to get all shoppingList elements.")
    @GetMapping(path = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shopping>> getAllElementsFromList(
            @RequestParam(value = "list name", defaultValue = "Standardliste") String listName) {

        return ResponseEntity.ok(shoppingDatabase.getAllElementsFromList(listName));
    }

    @ApiOperation("Request to get all shoppingList elements.")
    @GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shopping>> getAllElements() {

        return ResponseEntity.ok(shoppingDatabase.getAllElements());
    }

    @ApiOperation("Request to add a new shoppingList element.")
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shopping> addElement(
            @RequestBody ShoppingRequest request) {

        return ResponseEntity.ok(shoppingDatabase.addElement(request.getListName(), request.getProductName(), request.getNumber()));
    }

    @ApiOperation("Request to update a shoppingList element.")
    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shopping> updateElement(
            @RequestBody ShoppingRequest request) {

        return ResponseEntity.ok(shoppingDatabase.updateElement(request.getListName(), request.getProductName(), request.getNumber()));
    }

    @ApiOperation("Request to update a shoppingList element.")
    @DeleteMapping(path = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shopping> removeElement(
            @RequestParam(value = "list name", defaultValue = "Standardliste") String listName,
            @RequestParam(value = "product name", defaultValue = "Apfel") String productName) {

        return ResponseEntity.ok(shoppingDatabase.removeElement(listName, productName));
    }

    @ApiOperation("Update the database with the backup file.")
    @PatchMapping(path = "/backup/load", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shopping>> loadBackup() throws IOException {

        return ResponseEntity.ok(shoppingDatabase.loadBackup());
    }

    @ApiOperation("Saves the entire table to a file.")
    @PatchMapping(path = "/backup/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shopping>> saveBackup() throws IOException {

        return ResponseEntity.ok(shoppingDatabase.saveBackup());
    }
}
