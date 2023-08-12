package br.com.quinze.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(nullable = false)
    private Integer numero7;

    @Column(nullable = false)
    private Integer numero8;

    @Column(nullable = false)
    private Integer numero9;

    @Column(nullable = false)
    private Integer numero10;

    @Column(nullable = false)
    private Integer numero11;

    @Column(nullable = false)
    private Integer numero12;

    @Column(nullable = false)
    private Integer numero13;

    @Column(nullable = false)
    private Integer numero14;

    @Column(nullable = false)
    private Integer numero15;
}