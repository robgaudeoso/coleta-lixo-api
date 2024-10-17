package br.com.fiap.coletalixo.repository;

import br.com.fiap.coletalixo.model.ColetaDeLixo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ColetaDeLixoRepository extends JpaRepository<ColetaDeLixo, Long> {

    public Optional<ColetaDeLixo> findByRegiao(String regiao);

    public List<ColetaDeLixo> findByDataColetaBetween(LocalDate dataInicial, LocalDate dataFinal);

}
