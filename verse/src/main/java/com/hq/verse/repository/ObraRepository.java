package com.hq.verse.repository;

import com.hq.verse.model.Categoria;
import com.hq.verse.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraRepository extends JpaRepository<Obra, Integer> {
    List<Obra> findByCategoria_Id(Integer categoriaId);
}
