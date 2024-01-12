package com.fcarrena.curso.boot.service;


import com.fcarrena.curso.boot.dao.FuncionarioDao;
import com.fcarrena.curso.boot.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
@Service
public class FuncionarioServiceImpl implements FuncionarioService{
    @Autowired
    private FuncionarioDao dao;
    @Transactional(readOnly = false)
    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }
    @Transactional(readOnly = false)
    @Override
    public void editar(Funcionario funcionario) {
dao.update(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
dao.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}
