package com.fcarrena.curso.boot.service;



import com.fcarrena.curso.boot.domain.Cargo;
import com.fcarrena.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);

    void editar(Cargo cargo);

    void excluir(Long id);

    Cargo buscarPorId( Long id);

    List<Cargo> buscarTodos();
    boolean cargosTemFuncionarios(Long id);

    PaginacaoUtil<Cargo> buscarPorPagina(int pagina, String direcao);
}
