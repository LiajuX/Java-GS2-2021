package br.com.fiap.producao.entity;

import java.io.Serializable;

public class Mercadoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nomeProduto;
	private String origem;
	private String destino;
	private String situacaoAtual;
	private String temperaturaIdeal;
	private String temperaturaAtual;

	@Override
	public String toString() {		
		return "Mercadoria [codigo = " + codigo
									+ ", nome = " + nomeProduto
									+ ", origem = " + origem
									+ ", destino = " + destino
									+ ", sitAtual = " + situacaoAtual
									+ ", tempIdeal = " + temperaturaIdeal 
									+ ", tempAtual = " + temperaturaAtual
				+ "]";
	}
	
	public Mercadoria(int codigo, String nome, String origem, String destino, String sitAtual, String tempIdeal, String tempAtual) {
		super();
		this.setCodigo(codigo);
		this.setNomeProduto(nome);
		this.setOrigem(origem);
		this.setDestino(destino);
		this.setSituacaoAtual(sitAtual);
		this.setTemperaturaIdeal(tempIdeal);
		this.setTemperaturaAtual(tempAtual);
	}
	
	public Mercadoria() {}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getSituacaoAtual() {
		return situacaoAtual;
	}
	
	public void setSituacaoAtual(String situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}
	
	public String getTemperaturaIdeal() {
		return temperaturaIdeal;
	}
	
	public void setTemperaturaIdeal(String temperaturaIdeal) {
		this.temperaturaIdeal = temperaturaIdeal;
	}
	
	public String getTemperaturaAtual() {
		return temperaturaAtual;
	}
	
	public void setTemperaturaAtual(String temperaturaAtual) {
		this.temperaturaAtual = temperaturaAtual;
	}
}
