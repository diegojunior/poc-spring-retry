package br.com.dtech.pocspringretry.service.impl;

import org.springframework.stereotype.Service;

import br.com.dtech.pocspringretry.service.ConvivenciaService;
@Service
public class ConvivenciaServiceImpl implements ConvivenciaService {

	@Override
	public boolean excutaOperacaoConvivencia(String operacao) {
		if (operacao.isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean excutaOperacaoConvivenciaComTentativa(String operacao, int retryCount) {
		if (operacao.isEmpty() && retryCount == 0)
			return false;
		return true;
	}

}
