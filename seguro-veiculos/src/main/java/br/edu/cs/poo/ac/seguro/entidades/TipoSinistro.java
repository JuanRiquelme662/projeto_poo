package br.edu.cs.poo.ac.seguro.entidades;

/*
 * Implementar um enum com as seguintes constantes:
 * 
 * 	COLISAO(1,"Colisão"),
	INCENDIO(2,"Incêndio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depredação");
 * 
 * O enum deve ter construtor privado, métodos get públicos para os atributos codigo e nome,
 * e um método público e estático TipoSinistro getTipoSinistro(int codigo), que 
 * retorna o tipo de sinistro correspondente ao código recebido como parâmetro
 */
public enum TipoSinistro {
    COLISAO(1,"Colisão"),
	INCENDIO(2,"Incêndio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depredação");

    private int codigo;
    private String nome;

    private TipoSinistro(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo(){
        return codigo;
    }
    //nao se usa set em nem um dos dois porque esses valores nao podem ser alterados, eles sao fixos
    public String getNome(){
        return nome;
    }
    
}