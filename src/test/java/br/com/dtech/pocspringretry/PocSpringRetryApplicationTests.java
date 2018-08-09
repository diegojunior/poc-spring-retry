package br.com.dtech.pocspringretry;

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

	@Test(expected = RuntimeException.class)
	public void contextLoads() {
		retryTemplate.execute(retry -> {
			System.out.println("###### Entrei aqui #### ");
			boolean result = convivenciaService.excutaOperacaoConvivencia("");
			return result;
		});
	}

}
