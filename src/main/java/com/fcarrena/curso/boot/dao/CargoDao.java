package com.fcarrena.curso.boot.dao;




import com.fcarrena.curso.boot.domain.Cargo;
import com.fcarrena.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface CargoDao {
    void save(Cargo cargo);

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

    PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao);
}
