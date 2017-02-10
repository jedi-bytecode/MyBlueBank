package br.com.mycompany.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mycompany.exceptions.SaldoInsuficienteException;
import br.com.mycompany.model.ContaModel;

@Repository
public class ContaRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	@javax.transaction.Transactional
	public void Salvar(ContaModel contaModel){
		
		manager.persist(contaModel);		
	}
	
	@javax.transaction.Transactional
	public void Alterar(ContaModel contaModel){
				
		manager.merge(contaModel);		
	}

	@javax.transaction.Transactional
	public void Excluir(int id){
		
		ContaModel contaModel = this.ConsultarPorCodigo(id);
		
		manager.remove(contaModel);
		
	}
	
	@javax.transaction.TransactionScoped
	public void Transferir(ContaModel contaDestinoModel, ContaModel contaModel){
		
//		manager.getTransaction().begin();
		
		debitar(contaModel);
		contaDestinoModel.setSaldo(contaDestinoModel.getSaldo().add(contaModel.getValtransf()));
				
		manager.merge(contaDestinoModel);
		manager.merge(contaModel);
		
//		manager.getTransaction().commit();
				
	}
		
	public ContaModel ConsultarPorCodigo(int id){
		
		return manager.find(ContaModel.class, id);		
	} 
	
	public ContaModel ConsultarPorConta(int conta){
		
		Query query = manager.createQuery("SELECT c FROM ContaModel c WHERE c.nroconta = :nrocontadest");
		query.setParameter("nrocontadest", conta);
		ContaModel contaModel = (ContaModel) query.getSingleResult();
		
		return contaModel;		
	} 	
	
	public List<ContaModel> TodasContas(){

		return manager.createQuery("SELECT c FROM ContaModel c ORDER BY c.nome ").getResultList();	
	}
	
	public void debitar(ContaModel contaModel) throws SaldoInsuficienteException{ 
		
		if (contaModel.getValtransf().compareTo(contaModel.getSaldo()) > 0){
			throw new SaldoInsuficienteException("Saldo insuficiente! Tente com outro valor.");
		} else {
			contaModel.setSaldo(contaModel.getSaldo().subtract(contaModel.getValtransf()));
		}
					
	}	
}
