package br.edu.cs.poo.ac.seguro.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;
import br.edu.cs.poo.ac.seguro.entidades.TipoSinistro;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;

public class TesteSinistroDAO extends TesteDAO {
    private SinistroDAO dao = new SinistroDAO();
    protected Class getClasse() {
        return Sinistro.class;
    }
    //lembrar de criar um veicuolo
    @Test
    public void teste01() {
        String numero = "00000000";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        cadastro.incluir(si, numero);
        Sinistro resultado = dao.buscar(numero);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void teste02() {
        String numero = "00000000";
        String numero_2 = "00000001";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        cadastro.incluir(si, numero);
        Sinistro resultado = dao.buscar(numero_2);
        Assertions.assertNull(resultado);
    }
    
    @Test
    public void teste03() {
        String numero = "00000002";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        cadastro.incluir(si, numero);
        boolean resultado = dao.excluir(numero);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void teste04() {
        String numero = "00000000";
        String numero_2 = "00000003";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        cadastro.incluir(si, numero);
        boolean resultado = dao.excluir(numero_2);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void teste05() {
        String numero = "40000000";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        boolean ret = dao.incluir(si);
        Assertions.assertTrue(ret);
        Sinistro ve = dao.buscar(numero);
        Assertions.assertNotNull(ve);
    }

    @Test
    public void teste06() {
        String numero = "50000000";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        cadastro.incluir(si, numero);
        boolean resultado = dao.incluir(si);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void teste07() {
        String numero = "60000000";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        boolean ret = dao.alterar(si);
        Assertions.assertFalse(ret);
        Sinistro ve = dao.buscar(numero);
        Assertions.assertNull(ve);
    }

    @Test
    public void teste08() {
        String numero = "70000000";
        Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.COLISAO);
        si.setNumero(numero);
        cadastro.incluir(si, numero);
        si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario1", BigDecimal.ZERO, TipoSinistro.FURTO);
        si.setNumero(numero);
        boolean resultado = dao.alterar(si);
        Assertions.assertTrue(resultado);
    }
}
