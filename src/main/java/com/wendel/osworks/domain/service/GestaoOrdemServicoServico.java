package com.wendel.osworks.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendel.osworks.domain.model.OrdemServico;
import com.wendel.osworks.domain.model.StatusOrdemServico;
import com.wendel.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoServico {

	@Autowired
	private OrdemServicoRepository ordemServicoRespository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return ordemServicoRespository.save(ordemServico);
	}
}
