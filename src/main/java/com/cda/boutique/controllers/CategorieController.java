package com.cda.boutique.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.boutique.dtos.CategorieDTO;
import com.cda.boutique.dtos.CategorieRequestDTO;
import com.cda.boutique.services.CategorieService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping(value="/api/categories", produces="application/json")
@RequiredArgsConstructor
public class CategorieController {
    
    private final CategorieService categorieService;


    @GetMapping
    public ResponseEntity<List<CategorieDTO>> getCategories(){
        return ResponseEntity.ok(categorieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieDTO> getCategorie(@PathVariable("id") Integer id){
        return ResponseEntity.ok(categorieService.find(id));
    }
    
    @PostMapping
    public ResponseEntity<String> addCategorie(@RequestBody CategorieRequestDTO categorie){
        categorieService.save(categorie);
        return ResponseEntity.ok("{\"message\": \"Categorie à bien été ajouté\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategorie(@PathVariable("id") Integer id,@RequestBody CategorieRequestDTO categorie){
        categorieService.update(categorie, id);
        return ResponseEntity.ok("{\"message\": \"Categorie à bien été modifié\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategorie(@PathVariable("id") Integer id){
        categorieService.remove(id);
        return ResponseEntity.ok("{\"message\": \"Categorie à bien été supprimé\"}");
    }
}
