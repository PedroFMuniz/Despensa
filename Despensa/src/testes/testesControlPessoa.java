package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import control.*;
import model.*;
class testesControlPessoa {

	@Test
	void testListar() throws SAXException, IOException, ParserConfigurationException {
		ControlPessoa p = new ControlPessoa();
		assertEquals(0, p.listar().get(0).getId());
		assertEquals("Pedro", p.listar().get(0).getNome());
	}
	
	@Test
	void testListarId() throws SAXException, IOException, ParserConfigurationException {
		ControlPessoa p = new ControlPessoa();
		assertEquals(0, p.listar(0).get(0).getId());
		assertEquals("Pedro", p.listar(0).get(0).getNome());
	}
	
	@Test
	void testListarNome() throws SAXException, IOException, ParserConfigurationException {
		ControlPessoa p = new ControlPessoa();
		assertEquals(0, p.listar("Pedro").get(0).getId());
		assertEquals("Pedro", p.listar("pedro").get(0).getNome());
	}
	
	@Test
	void testGravar() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		ControlPessoa p = new ControlPessoa();
		Pessoa pessoa = new Pessoa(2, "Jorge");
		p.Gravar(pessoa);
		assertEquals(2, p.listar(2).get(0).getId());
		assertEquals("Jorge", p.listar(2).get(0).getNome());
	}
	
	@Test
	void testEditar() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		ControlPessoa p = new ControlPessoa();
		Pessoa pessoa = new Pessoa(1, "Editado");
		p.Editar(pessoa);
		assertEquals(1, p.listar(1).get(0).getId());
		assertEquals("Editado", p.listar(1).get(0).getNome());
	}
	
	@Test
	void testExcluir() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		ControlPessoa p = new ControlPessoa();
		Pessoa pessoa = new Pessoa(1, "Editado");
		p.Excluir(pessoa);
		assertEquals(null, p.listar(1));
	}

}
