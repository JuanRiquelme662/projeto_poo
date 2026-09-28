package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;

public class TesteApoliceDAO extends TesteDAO {
    private ApoliceDAO dao = new ApoliceDAO();
    protected Class getClasse() {
        return Apolice.class;
    }
    //lembrar de criar um veicuolo
    @Test
    public void teste01() {
        String numero = "00000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        Apolice resultado = dao.buscar(numero);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void teste02() {
        String numero = "10000000";
        String numero_2 = "10000001";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        Apolice resultado = dao.buscar(numero_2);
        Assertions.assertNull(resultado);
    }

    @Test
    public void teste03() {
        String numero = "20000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        boolean resultado = dao.excluir(numero);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void teste04() {
        String numero = "30000000";
        String numero_2 = "30000003";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        boolean resultado = dao.excluir(numero_2);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void teste05() {
        String numero = "40000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        boolean ret = dao.incluir(ap);
        Assertions.assertTrue(ret);
        Apolice resultado = dao.buscar(numero);
        Assertions.assertNotNull(resultado);
    }

    @Test 
    public void teste06() {
        String numero = "50000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        boolean ret = dao.incluir(ap);
        Assertions.assertFalse(ret);
    }

    @Test 
    public void teste07() {
        String numero = "60000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        boolean ret = dao.alterar(ap);
        Assertions.assertFalse(ret);
        Apolice ve = dao.buscar(numero);
        Assertions.assertNull(ve);
    }

    @Test
    public void teste08() {
        String numero = "70000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        ap = new Apolice(null, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN);
        ap.setNumero(numero);
        boolean resultado = dao.alterar(ap);
        Assertions.assertTrue(resultado);
    }
}