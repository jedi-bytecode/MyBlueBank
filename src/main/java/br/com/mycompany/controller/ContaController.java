package br.com.mycompany.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.mycompany.exceptions.SaldoInsuficienteException;
import br.com.mycompany.model.ContaModel;
import br.com.mycompany.model.ResultadoModel;
import br.com.mycompany.repository.ContaRepository;
import br.com.mycompany.rules.RegraNegocio;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ResultadoModel resultadoModel;
	
	@Autowired
	ContaRepository contaRepository;
	
	RegraNegocio regraNegocio;
			
	@RequestMapping(value ="/incluirConta.html", method= RequestMethod.GET)
	public ModelAndView IncluirConta(){
		
		return new ModelAndView("incluirConta");
	}	
	
	// Consultar contas
	@RequestMapping(value ="/consultarContas.html", method= RequestMethod.GET)
	public ModelAndView Consultar(){
		
		return new ModelAndView("consultarContas");
	}

	// Consulta conta para alteração
	@RequestMapping(value ="/editarConta.html/{id}", method= RequestMethod.GET)
	public ModelAndView EditarRegistro(@PathVariable int id){
		
		ContaModel contaModel = contaRepository.ConsultarPorCodigo(id);
		
		return new ModelAndView("editarConta","contaModel", contaModel);
	}
	
	// Consulta conta para transferência
	@RequestMapping(value ="/transfConta.html/{id}", method= RequestMethod.GET)
	public ModelAndView TransfConta(@PathVariable int id){
		
		ContaModel contaModel = contaRepository.ConsultarPorCodigo(id);
		
		return new ModelAndView("transfConta","contaModel", contaModel);
	}

	// Incluir conta
	@RequestMapping(value="/salvar", method= RequestMethod.POST)
	public @ResponseBody ResultadoModel Salvar(@RequestBody ContaModel contaModel){
	
		try {
			
			contaRepository.Salvar(contaModel);
			
			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Conta cadastrada com sucesso!");
			
		} catch (Exception e) {
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao salvar o registro ("+e.getMessage()+")");
		}
				
		return resultadoModel;
	}
	
	// Alterar Conta
	@RequestMapping(value="/alterar", method= RequestMethod.POST)
	public @ResponseBody ResultadoModel Alterar(@RequestBody ContaModel contaModel){
		try {
						
			contaRepository.Alterar(contaModel);
			
			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Conta alterada com sucesso!");
			
		} catch (Exception e) {
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao salvar o registro ("+e.getMessage()+")");
		}
				
		return resultadoModel;
	}

	// Tranferência de valores
	@RequestMapping(value="/transferir", method= RequestMethod.POST)
	public @ResponseBody ResultadoModel Transferir(@RequestBody ContaModel contaModel){
		
		try {
			
			ContaModel contaDestinoModel = contaRepository.ConsultarPorConta(contaModel.getNrocontadest());
			
			contaRepository.Transferir(contaDestinoModel, contaModel);
			
			resultadoModel.setCodigo(1);			
			resultadoModel.setMensagem("Transferência realizada com sucesso!");
			
		} catch (SaldoInsuficienteException e) {
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao realizar a transação: ("+e.getMessage()+")");
			
		} catch (NoResultException e) {
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Conta Destino Inexistente: ("+e.getMessage()+")");
			
		} catch (Exception e) {
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao salvar o registro ("+e.getMessage()+")");
			
		}
		
		return resultadoModel;
			
	}	

	// Pesquisa conta destino para transferência
	public ContaModel pesquisarContaDest (ContaModel contaModel) {
		
		ContaModel contaDestinoModel = contaRepository.ConsultarPorConta(contaModel.getNrocontadest());
				
		return contaDestinoModel;
	}
	
	// Consulta todas contas cadastradas
	@RequestMapping(value="/consultarTodasContas", method= RequestMethod.GET)
	public @ResponseBody List<ContaModel> ConsultarTodasContas(){
		
		return contaRepository.TodasContas();
		
	}
	
	// Excluir uma conta
	@RequestMapping(value="/excluirConta/{id}", method= RequestMethod.DELETE)
	public @ResponseBody void ExcluirConta(@PathVariable int id){
				
		contaRepository.Excluir(id);
				
	}
	
}
