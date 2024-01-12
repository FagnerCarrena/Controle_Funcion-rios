package com.fcarrena.curso.boot.dao;


import com.fcarrena.curso.boot.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao{
}
