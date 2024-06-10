package gestor.registro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("gestor.registro")
public class GestorRegistroFaturamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorRegistroFaturamentoApplication.class, args);
	}

}
