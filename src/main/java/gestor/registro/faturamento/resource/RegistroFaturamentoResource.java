package gestor.registro.faturamento.resource;


import gestor.registro.faturamento.service.RegistroFaturamentoService;
import gestor.registro.lib.records.DadoFaturamentoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestao-projeto/faturamento")
public class RegistroFaturamentoResource implements GestaoProjetoResource {

    @Autowired
    private RegistroFaturamentoService faturamentoService;
    @PostMapping(value = "/registrar")
    public ResponseEntity<GestaoProjetoResponse<String>> criarFaturamento(@RequestBody DadoFaturamentoRecord dadoFaturamentoRecord) {
        faturamentoService.gerarParcela(dadoFaturamentoRecord);
        return retornarSucesso(null);
    }
}
