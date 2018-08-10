package br.com.dtech.pocspringretry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.com.dtech.pocspringretry.config.RetryConfiguration;
import br.com.dtech.pocspringretry.service.ConvivenciaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  classes = {LoaderDependency.class, RetryConfiguration.class},
  loader = AnnotationConfigContextLoader.class)
public class PocSpringRetryApplicationTests {
	
	@Autowired
	private ConvivenciaService convivenciaService;
	
	@Autowired
	private RetryTemplate retryTemplate;

	@Test
	public void testeRetry() {
		Boolean status = retryTemplate.execute(retry -> {
			boolean result = convivenciaService.excutaOperacaoConvivencia("");
			if (!result) 
				throw new RuntimeException("Erro ao invocar a convivencia");
			return result;
			
		}, recoverCallback -> {
			return false;
		});
		
		Assert.assertFalse(status);
	}
	
	@Test
	public void testeSuccess() {
		Boolean status = retryTemplate.execute(retry -> {
			boolean result = convivenciaService.excutaOperacaoConvivencia("asdf");
			if (!result) 
				throw new RuntimeException("Erro ao invocar a convivencia");
			return result;
			
		}, recoverCallback -> {
			return true;
		});
		
		Assert.assertTrue(status);
	}
	
	@Test
	public void testeSuccessSegundaTentativa() {
		Boolean status = retryTemplate.execute(retry -> {
			boolean result = convivenciaService.excutaOperacaoConvivenciaComTentativa("", retry.getRetryCount());
			if (!result) 
				throw new RuntimeException("Erro ao invocar a convivencia");
			return result;
			
		}, recoverCallback -> {
			return true;
		});
		
		Assert.assertTrue(status);
	}

}
