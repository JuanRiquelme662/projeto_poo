package br.edu.cs.poo.ac.seguro.entidades;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Veiculo implements Serializable {
    private String placa;
    private int ano;
    private Segurado proprietario;
    private CategoriaVeiculo categoria;
}
