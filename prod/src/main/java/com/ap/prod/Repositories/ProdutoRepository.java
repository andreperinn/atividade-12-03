package com.ap.prod.Repositories;

import com.ap.prod.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
}
