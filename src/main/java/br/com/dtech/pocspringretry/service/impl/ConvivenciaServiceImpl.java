package br.com.dtech.pocspringretry.service.impl;

import org.springframework.stereotype.Service;

import br.com.dtech.pocspringretry.service.ConvivenciaService;
@Service
public class ConvivenciaServiceImpl implements ConvivenciaService {

	@Override
	public boolean excutaOperacaoConvivencia(String operacao) {
		throw new RuntimeException();
	}

}
