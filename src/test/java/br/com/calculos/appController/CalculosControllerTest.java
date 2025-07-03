package br.com.calculos.appController;

import br.com.calculos.CalculosController.CalculosController;
import br.com.calculos.CalculosEntity.Resultado;
import br.com.calculos.CalculosRepository.CalculosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculosControllerTest {

    @Autowired
    CalculosController calculosController;

    @MockitoBean
    CalculosRepository calculosRepository;

    @BeforeEach
    void setup(){
        List<Resultado> resultados = new ArrayList<>();
        resultados.add(new Resultado(1L, 10, 10.0, 30));
        resultados.add(new Resultado(2L, 100, 10.0, 350));
        resultados.add(new Resultado(3L, 1000, 10.0, 30));

        Resultado resultado = new Resultado(1L, 12, 50, 100);

        when(calculosRepository.findAll()).thenReturn(resultados);
        when(calculosRepository.findById(1L)).thenReturn(Optional.of(resultado));
    }

    @Test
    void cenario01(){

        ResponseEntity<List<Resultado>> retorno = this.calculosController.findAll();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }

    @Test
    void cenario02(){

        ResponseEntity<Resultado> retorno = this.calculosController.findById(1L);

        assertEquals(12, retorno.getBody().getSoma());
    }
}
