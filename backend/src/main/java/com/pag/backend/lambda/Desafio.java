package com.pag.backend.lambda;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.pag.backend.domain.Product;

public class Desafio {
	public static void main(String[] args) {
		
		Function<Product, Double> calculaPrecoReal = p -> 
				p.getSuggestedPrice().doubleValue() * (1- p.getDiscount());
		
		UnaryOperator<Double> calculaImposto = valor -> 
				 valor >=2500 ? valor*(1.085) : valor;
		
		UnaryOperator<Double> calculaFrete =  valor -> 
				valor >=3000 ? valor+100  : valor+50;	
		
		Consumer<Double> imprimeValorFormatado = valor -> System.out.printf("R$%.2f",valor);
		
		Product p = new Product(1, "iPad", BigDecimal.valueOf(3235.89),0.13);
		Double resultadoFinal = calculaPrecoReal.andThen(calculaImposto).andThen(calculaFrete).apply(p);
		
		imprimeValorFormatado.accept(resultadoFinal);
		
	}
}
