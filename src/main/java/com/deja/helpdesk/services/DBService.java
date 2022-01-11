package com.deja.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deja.helpdesk.domain.Chamado;
import com.deja.helpdesk.domain.Cliente;
import com.deja.helpdesk.domain.Tecnico;
import com.deja.helpdesk.domain.enums.Perfil;
import com.deja.helpdesk.domain.enums.Prioridade;
import com.deja.helpdesk.domain.enums.Status;
import com.deja.helpdesk.repositories.ChamadoRepository;
import com.deja.helpdesk.repositories.ClienteRepository;
import com.deja.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Deja Lazzarotto", "63653230268", "deja@deja.com.br", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Juli Lazzarotto", "80527954780", "juli@deja.com.br", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
