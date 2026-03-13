package com.ap.prod.Controllers;


import com.ap.prod.Models.ProdutoModel;
import com.ap.prod.ProdApplication;
import com.ap.prod.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;



    @GetMapping
    public ResponseEntity<List<ProdutoModel> > findAll(){
        List<ProdutoModel> requeste = produtoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }


    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel request = produtoModel.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(produtoModel.getId())
                .toUri();
        return ResponseEntity.created().body(request);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar (@PathVariable Long id),@RequestBody ProdutoModel produtoModel){
        return produtoService.atualizar(id,produtoModel);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
