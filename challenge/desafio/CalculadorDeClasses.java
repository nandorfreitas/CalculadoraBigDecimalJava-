package desafio;

import interfaces.Calculavel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import annotation.Somar;
import annotation.Subtrair;

public class CalculadorDeClasses implements Calculavel {
	
	
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		CalculadorDeClasses teste = new CalculadorDeClasses();
	
		 BigDecimal big1 = new BigDecimal("9.1");
         BigDecimal big2 = new BigDecimal("8.2");
         BigDecimal big3 = new BigDecimal("4.1");
      
         NotaAluno aluno = new NotaAluno(big1,big2,big3,15, "Eduardo");
        
         
         System.out.println(teste.Somar(aluno));
         System.out.println(teste.Subtrair(aluno));
         System.out.println(teste.Totalizar(aluno));
        	
       	}
       
	
	public BigDecimal Somar(Object qualquer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 BigDecimal totalSoma = BigDecimal.ZERO;
		 for (Method metodos : qualquer.getClass().getDeclaredMethods()) {
        	 if(metodos.isAnnotationPresent(Somar.class) && metodos.getReturnType().toString().contains("BigDecimal")) {
        		 BigDecimal nota = new BigDecimal(metodos.invoke(qualquer).toString());
        		 totalSoma = totalSoma.add(nota);
        	 }
		 }	 
		return totalSoma;
	}


	public BigDecimal Subtrair(Object qualquer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		 BigDecimal totalSubtracao = BigDecimal.ZERO;
		 for (Method metodos : qualquer.getClass().getDeclaredMethods()) {
        	 if(metodos.isAnnotationPresent(Subtrair.class) && metodos.getReturnType().toString().contains("BigDecimal")) {
        		 BigDecimal nota = new BigDecimal(metodos.invoke(qualquer).toString());
        		 totalSubtracao = totalSubtracao.subtract(nota);
        	 }
		 }	 
		return totalSubtracao;
	}

	public BigDecimal Totalizar(Object qualquer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException   {
		BigDecimal totalSoma = BigDecimal.ZERO;
		BigDecimal totalSubtracao = BigDecimal.ZERO;
		 for (Method metodos : qualquer.getClass().getDeclaredMethods()) {
        	 if(metodos.isAnnotationPresent(Somar.class) && metodos.getReturnType().toString().contains("BigDecimal")) {
        		 BigDecimal nota = new BigDecimal(metodos.invoke(qualquer).toString());
        		 totalSoma = totalSoma.add(nota);
        	 }
        	 if(metodos.isAnnotationPresent(Subtrair.class) && metodos.getReturnType().toString().contains("BigDecimal")) {
        		 BigDecimal nota = new BigDecimal(metodos.invoke(qualquer).toString());
        		 totalSubtracao = totalSubtracao.subtract(nota);
        	 }
		 }	 
		return totalSoma.add(totalSubtracao);
	}


}
