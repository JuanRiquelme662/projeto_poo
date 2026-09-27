package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter 
@Setter 
public class Apolice implements Serializable {
    private String numero;
    private Veiculo veiculo;
    private BigDecimal valorFranquia;
    private BigDecimal valorPremio;
    private BigDecimal valorMaximoSegurado;

    //mesmo caso do numero em sinistro, numero nao aparece na apolice pois vai ir para os DAOs

    public Apolice(Veiculo veiculo, BigDecimal valorFranquia, BigDecimal valorPremio, BigDecimal valorMaximoSegurado) {
        this.veiculo = veiculo;
        this.valorFranquia = valorFranquia;
        this.valorPremio = valorPremio;
        this.valorMaximoSegurado = valorMaximoSegurado;
    }
}
