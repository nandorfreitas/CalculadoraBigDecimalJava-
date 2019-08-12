package desafio;

import java.math.BigDecimal;

import annotation.Somar;
import annotation.Subtrair;

public class NotaAluno {
	
	BigDecimal notaMatematica;
	BigDecimal notaBiologia;
	BigDecimal notaPortugues;
	int idAluno;
	String nomeAluno;
	
	
	public NotaAluno(BigDecimal notaMatematica, BigDecimal notaBiologia, BigDecimal notaPortugues, int idAluno,String nomeAluno) {
		this.notaMatematica = notaMatematica;
		this.notaBiologia = notaBiologia;
		this.notaPortugues = notaPortugues;
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
	}
	
	
	@Somar()
	public BigDecimal getNotaMatematica() {
		return notaMatematica;
	}

	public void setNotaMatematica(BigDecimal notaMatematica) {
		this.notaMatematica = notaMatematica;
	}

	@Subtrair
	@Somar()
	public BigDecimal getNotaBiologia() {
		return notaBiologia;
	}

	public void setNotaBiologia(BigDecimal notaBiologia) {
		this.notaBiologia = notaBiologia;
	}

	@Somar()
	@Subtrair
	public BigDecimal getNotaPortugues() {
		return notaPortugues;
	}

	
	public void setNotaPortugues(BigDecimal notaPortugues) {
		this.notaPortugues = notaPortugues;
	}

	@Somar()
	public int getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	

}
