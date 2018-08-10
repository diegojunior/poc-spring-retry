package br.com.dtech.pocspringretry.service;

public interface ConvivenciaService {

	public boolean excutaOperacaoConvivencia(String operacao);

	public boolean excutaOperacaoConvivenciaComTentativa(String string, int retryCount);
}
