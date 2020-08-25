package com.wendel.osworks.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendel.osworks.domain.exception.NegocioException;
import com.wendel.osworks.domain.model.Cliente;
import com.wendel.osworks.domain.model.OrdemServico;
import com.wendel.osworks.domain.model.StatusOrdemServico;
import com.wendel.osworks.domain.repository.ClienteRepository;
import com.wendel.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoServico {

	@Autowired
	private OrdemServicoRepository ordemServicoRespository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente  cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return ordemServicoRespository.save(ordemServico);
	}
}
