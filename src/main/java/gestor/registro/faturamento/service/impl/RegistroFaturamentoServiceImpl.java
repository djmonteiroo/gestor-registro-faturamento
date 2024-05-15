package gestor.registro.faturamento.service.impl;

import gestor.registro.faturamento.respository.DadoFaturamentoRepository;
import gestor.registro.faturamento.respository.ProjetoRepository;
import gestor.registro.faturamento.service.RegistroFaturamentoService;
import gestor.registro.lib.entity.DadoFaturamento;
import gestor.registro.lib.records.DadoFaturamentoRecord;
import gestor.registro.lib.utils.GestaoProjetoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistroFaturamentoServiceImpl implements RegistroFaturamentoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private DadoFaturamentoRepository dadoFaturamentoRepository;
    @Override
    public void gerarParcela(final DadoFaturamentoRecord dadoFaturamentoRecord) {
        log.info(GestaoProjetoUtils.getMensagem("Gerando parcelas para dado faturamento ", dadoFaturamentoRecord.idDadoFaturamento()));
        DadoFaturamento dadoFaturamento =  dadoFaturamentoRepository.findById(dadoFaturamentoRecord.idDadoFaturamento()).orElseThrow(() -> new RuntimeException(GestaoProjetoUtils.getMensagem("Dado de faturamento não encontrado na base")));

        System.out.println(dadoFaturamento.getProjeto());
    }
}
