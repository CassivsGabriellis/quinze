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
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private Integer number1;

    @Column(nullable = false)
    private Integer number2;

    @Column(nullable = false)
    private Integer number3;

    @Column(nullable = false)
    private Integer number4;

    @Column(nullable = false)
    private Integer number5;

    @Column(nullable = false)
    private Integer number6;
}