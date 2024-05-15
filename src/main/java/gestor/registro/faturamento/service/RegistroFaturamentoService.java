package gestor.registro.faturamento.service;

import gestor.registro.lib.records.DadoFaturamentoRecord;
import org.springframework.stereotype.Component;

@Component
public interface RegistroFaturamentoService {
    public void gerarParcela(final DadoFaturamentoRecord dadoFaturamentoRecord);
}
