package com.ap.prod.Services;

import com.ap.prod.Repositories.ProdutoRepository;
import com.ap.prod.Models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List <ProdutoModel> findAll(){
        return  produtoRepository.findAll();
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        return produtoRepository.save(model);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }




}
