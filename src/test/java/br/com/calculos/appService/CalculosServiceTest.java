package br.com.calculos.appService;

import br.com.calculos.CalculosEntity.Entrada;
import br.com.calculos.CalculosService.CalculosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculosServiceTest {

    @Autowired
    CalculosService calculosService;

    @Test
    void cenario01(){

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(4);
        lista.add(3);

        Entrada entrada = new Entrada();
        entrada.setLista(lista);

        int retorno = calculosService.buscarMaiorNumero(entrada);
        assertEquals(4, retorno);
    }

    @Test
    void cenario02(){

        List<Integer> lista = new ArrayList<>();
        lista.add(null);
        lista.add(2);
        lista.add(4);
        lista.add(3);

        Entrada entrada = new Entrada();
        entrada.setLista(lista);

        int retorno = calculosService.buscarMaiorNumero(entrada);
        assertEquals(4, retorno);
    }
}
