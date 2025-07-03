package br.com.calculos.CalculosRepository;

import br.com.calculos.CalculosEntity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculosRepository extends JpaRepository<Resultado, Long>{
}
