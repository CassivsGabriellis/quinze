package br.com.quinze.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "combinations")
public class CombinationNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private Integer numero1;

    @Column(nullable = false)
    private Integer numero2;

    @Column(nullable = false)
    private Integer numero3;

    @Column(nullable = false)
    private Integer numero4;

    @Column(nullable = false)
    private Integer numero5;

    @Column(nullable = false)
    private Integer numero6;
}