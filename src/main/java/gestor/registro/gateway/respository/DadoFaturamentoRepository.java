package gestor.registro.gateway.respository;

import gestor.registro.lib.entity.DadoFaturamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadoFaturamentoRepository extends JpaRepository<DadoFaturamento, Long> {
}
