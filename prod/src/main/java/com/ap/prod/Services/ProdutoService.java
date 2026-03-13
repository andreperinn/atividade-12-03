package com.ap.prod.Services;

import Repositories.ProdutoRepository;
import com.ap.prod.Models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoModel.save(produtoModel);
    }




}
