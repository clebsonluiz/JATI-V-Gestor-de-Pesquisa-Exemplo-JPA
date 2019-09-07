package br.edu.jati5.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import br.edu.jati5.entidade.Pesquisa;
import br.edu.jati5.exceptions.DAOException;

public class DAOPesquisa extends DAO<Pesquisa>{

	
	public double andamento_pesquisa(java.sql.Date data1, java.sql.Date data2) throws DAOException {
		EntityManager entityManager = createEntityManager();
		double diferenca;
		try {
			
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("andamento_pesquisa");
			query.registerStoredProcedureParameter(0, java.sql.Date.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(1, java.sql.Date.class, ParameterMode.IN);
			query.setParameter(0, data1);
			query.setParameter(1, data2);

			diferenca = (double) query.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
			diferenca = 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Erro de busca no banco de dados");
		} finally {
			entityManager.close();
		}
		return diferenca;
	}
}
