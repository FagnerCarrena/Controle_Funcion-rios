package com.fcarrena.curso.boot.dao;


import com.fcarrena.curso.boot.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao{
}
