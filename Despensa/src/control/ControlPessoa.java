package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.*;

public class ControlPessoa {

	public Document getXML() throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("/home/pedro/git/Despensa/Despensa/src/data/dataPessoa.xml"));
		return doc;
	}

	public void setXML(Document doc) throws FileNotFoundException, TransformerException {
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(
				new FileOutputStream("/home/pedro/git/Despensa/Despensa/src/data/dataPessoa.xml"));
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.transform(source, result);
	}

	public ArrayList<Pessoa> listar() throws SAXException, IOException, ParserConfigurationException {
		Document doc = getXML();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		Element root = doc.getDocumentElement();
		Element p = (Element) root.getElementsByTagName("pessoas").item(0);
		NodeList ps = p.getElementsByTagName("pessoa");
		for (int i = 0; i < ps.getLength(); i++) {
			Element e = (Element) ps.item(i);
			int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
			String nome = e.getElementsByTagName("nome").item(0).getTextContent();
			Pessoa pessoa = new Pessoa(id, nome);
			pessoas.add(pessoa);
		}
		return pessoas;
	}

	public ArrayList<Pessoa> listar(int idItem) throws SAXException, IOException, ParserConfigurationException {
		Document doc = getXML();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		Element root = doc.getDocumentElement();
		Element p = (Element) root.getElementsByTagName("pessoas").item(0);
		NodeList ps = p.getElementsByTagName("pessoa");
		for (int i = 0; i < ps.getLength(); i++) {
			Element e = (Element) ps.item(i);
			int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
			String nome = e.getElementsByTagName("nome").item(0).getTextContent();
			if (id == idItem) {
				Pessoa pessoa = new Pessoa(id, nome);
				pessoas.add(pessoa);
			}
		}
		return pessoas;
	}

	public ArrayList<Pessoa> listar(String nomeItem) throws SAXException, IOException, ParserConfigurationException {
		Document doc = getXML();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		Element root = doc.getDocumentElement();
		Element p = (Element) root.getElementsByTagName("pessoas").item(0);
		NodeList ps = p.getElementsByTagName("pessoa");
		for (int i = 0; i < ps.getLength(); i++) {
			Element e = (Element) ps.item(i);
			int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
			String nome = e.getElementsByTagName("nome").item(0).getTextContent();
			if (nome.toUpperCase().contains(nomeItem.toUpperCase())) {
				Pessoa pessoa = new Pessoa(id, nome);
				pessoas.add(pessoa);
			}
		}
		return pessoas;
	}

	public void Gravar(Pessoa p) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		Document doc = getXML();
		Element root = doc.getDocumentElement();
		Element pessoas = (Element) root.getElementsByTagName("pessoas").item(0);
		Element newPessoa = doc.createElement("pessoa");
		Element id = doc.createElement("id");
		Element nome = doc.createElement("nome");
		id.setTextContent(Integer.toString(p.getId()));
		nome.setTextContent(p.getNome());
		newPessoa.appendChild(id);
		newPessoa.appendChild(nome);
		pessoas.appendChild(newPessoa);
		setXML(doc);
	}

	public void Editar(Pessoa p) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		Document doc = getXML();
		Element root = doc.getDocumentElement();
		Element pessoas = (Element) root.getElementsByTagName("pessoas").item(0);
		NodeList ps = pessoas.getElementsByTagName("pessoa");
		for (int i = 0; i < ps.getLength(); i++) {
			Element e = (Element) ps.item(i);
			int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
			if (p.getId() == id) {
				Element nome1 = (Element) e.getElementsByTagName("nome").item(0);
				nome1.setTextContent(p.getNome());
				setXML(doc);
				break;
			}
		}
	}
}
