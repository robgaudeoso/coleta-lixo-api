package br.com.fiap.coletalixo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_coleta_lixo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColetaDeLixo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_COLETA_LIXO"
    )
    @SequenceGenerator(
            name = "SEQ_COLETA_LIXO",
            sequenceName = "SEQ_COLETA_LIXO",
            allocationSize = 1
    )
    private Long id;
    private String regiao;
    private String motorista;
    private String caminhao;

    @Column(name = "data_coleta")
    private LocalDate dataColeta;

}
