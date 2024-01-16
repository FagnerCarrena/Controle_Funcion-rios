package com.fcarrena.curso.boot.controller;

import com.fcarrena.curso.boot.domain.Cargo;
import com.fcarrena.curso.boot.domain.Departamento;
import com.fcarrena.curso.boot.service.CargoService;
import com.fcarrena.curso.boot.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {
@Autowired
private CargoService cargoService;
@Autowired
private DepartamentoService departamentoService;



    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";

    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/cargo/cadastro";
        }



        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/cargos/cadastrar";

    }
        @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();

    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/cargo/cadastro";
        }

        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (cargoService.cargosTemFuncionarios(id)) {
            attr.addFlashAttribute("fail", "Cargo não excluido. Tem funcionário(s) vinculado(s).");
        } else {
            cargoService.excluir(id);
            attr.addFlashAttribute("success", "Cargo excluido com sucesso.");
        }
        return "redirect:/cargos/listar";
    }


}
