package br.com.calculos.CalculosController;

import br.com.calculos.CalculosEntity.Entrada;
import br.com.calculos.CalculosEntity.Resultado;
import br.com.calculos.CalculosService.CalculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculos")
public class CalculosController {

    @Autowired
    private CalculosService calculosService;

    @GetMapping("/calcular")
    public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada){

        try {
            Resultado resultado = this.calculosService.calcular(entrada);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/maior")
    public ResponseEntity<Integer> buscarMaiorNumero(@RequestBody Entrada entrada){

        try {
            int maior = calculosService.buscarMaiorNumero(entrada);
            return new ResponseEntity<>(maior, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Resultado>> findAll(){

        try {
            List<Resultado> resultados = calculosService.findAll();
            return new ResponseEntity<>(resultados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Resultado> findById(@PathVariable Long id){

        try {
            Resultado resultado = calculosService.findById(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
