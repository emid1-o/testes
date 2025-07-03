package br.com.calculos.CalculosService;

import br.com.calculos.CalculosEntity.Entrada;
import br.com.calculos.CalculosEntity.Resultado;
import br.com.calculos.CalculosRepository.CalculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculosService {

    @Autowired
    private CalculosRepository calculosRepository;

    public Resultado calcular(Entrada entrada){

        int soma = 0;
        double media = 0;

        for (int i = 0; i < entrada.getLista().size(); i++){
            soma += entrada.getLista().get(i);
        }
        media = (double) soma / entrada.getLista().size();

        Resultado resultado = new Resultado();
        resultado.setSoma(soma);
        resultado.setMedia(media);

        int maiorNum = buscarMaiorNumero(entrada);

        resultado.setMaiorNumero(maiorNum);

        resultado = this.calculosRepository.save(resultado);
        return resultado;
    }

    public int buscarMaiorNumero(Entrada entrada){

        int maiorNumero = 0;

        for (int i = 0; i< entrada.getLista().size(); i++){

            if (entrada.getLista().get(i) == null){
                continue;
            }

            if (entrada.getLista().get(i) > maiorNumero){
                maiorNumero = entrada.getLista().get(i);
            }
        }


        return maiorNumero;
    }

    public List<Resultado> findAll(){

        return calculosRepository.findAll();
    }

    public Resultado findById(Long id){

        return calculosRepository.findById(id).get();
    }
}
