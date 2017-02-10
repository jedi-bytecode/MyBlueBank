package br.com.mycompany.rules;

import br.com.mycompany.exceptions.SaldoInsuficienteException;
import br.com.mycompany.model.ContaModel;

public class RegraNegocio {

	public void validaSaldo(ContaModel contaModel) throws SaldoInsuficienteException{ 
		
		if (contaModel.getValtransf().compareTo(contaModel.getSaldo()) < 0){
			throw new SaldoInsuficienteException("Saldo insuficiente! Tente com outro valor.");
		} else {
			contaModel.setSaldo(contaModel.getSaldo().subtract(contaModel.getValtransf()));
		}
					
	}
}
