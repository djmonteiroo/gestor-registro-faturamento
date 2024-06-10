package gestor.registro.gateway.service.impl;

import gestor.registro.gateway.respository.DadoFaturamentoRepository;
import gestor.registro.gateway.respository.ProjetoRepository;
import gestor.registro.gateway.service.RegistroFaturamentoService;
import gestor.registro.lib.dto.ParcelaDto;
import gestor.registro.lib.entity.DadoFaturamento;
import gestor.registro.lib.records.DadoFaturamentoRecord;
import gestor.registro.lib.utils.GestaoProjetoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        gerarValorParcela(dadoFaturamento);

    }

    private void gerarValorParcela(final DadoFaturamento dadoFaturamento) {
        List<ParcelaDto> lsParcela = new ArrayList<>();
        for(Integer nrParcela = 1; nrParcela <= dadoFaturamento.getQtParcela(); nrParcela++){
            ParcelaDto parcelaDto = new ParcelaDto();
            double resultado = 0;

            if (nrParcela < dadoFaturamento.getQtParcela()) {
                resultado = Math.floor((100.0 / dadoFaturamento.getQtParcela()) * 100) / 100; // TRUNCAR(100%/6;2)
                parcelaDto.setPercentualParcela(resultado);
            } else if (nrParcela == dadoFaturamento.getQtParcela()) {
                resultado = Math.floor((100.0 / dadoFaturamento.getQtParcela()) * 100) / 100; // TRUNCAR(100%/6;2)
                parcelaDto.setPercentualParcela(resultado);
            } else {
                resultado = 0;
                parcelaDto.setPercentualParcela(resultado);
            }
            lsParcela.add(parcelaDto);
        }
    }
}
