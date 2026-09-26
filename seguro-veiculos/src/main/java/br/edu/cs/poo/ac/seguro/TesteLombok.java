package br.edu.cs.poo.ac.seguro;


import lombok.Getter;
import lombok.Setter;

public class TesteLombok {
    @Getter
    @Setter
    private String nome;

    public static void main(String[] args) {
        TesteLombok t = new TesteLombok();
        t.setNome("Funcionou!");
        System.out.println(t.getNome());
    }
}