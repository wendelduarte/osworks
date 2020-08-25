package com.wendel.osworks.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wendel.osworks.domain.model.OrdemServico;
import com.wendel.osworks.domain.repository.OrdemServicoRepository;
import com.wendel.osworks.domain.service.GestaoOrdemServicoServico;

@RestController
@RequestMapping("ordens-servico")
public class OrdemServicoController {

	@Autowired
	private GestaoOrdemServicoServico gestaoOrdemServico;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
		return gestaoOrdemServico.criar(ordemServico);
	}
	
	public List<OrdemServico> listar(){
		return ordemServicoRepository.findAll();
	}
}
