package mz.kohiwa.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import mz.kohiwa.filter.DocFilter;
import mz.kohiwa.model.DocRegisto;
import mz.kohiwa.util.jpa.Transactional;
import mz.kohiwa.util.jsf.FacesUtil;

public class Registos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;

	@Transactional
	public DocRegisto guardar(DocRegisto docRegisto) {
		return manager.merge(docRegisto);
	}

	@Transactional
	public List<DocRegisto> registosFiltrados(DocFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<DocRegisto> criteriaQuery = builder.createQuery(DocRegisto.class);

		Root<DocRegisto> registoRoot = criteriaQuery.from(DocRegisto.class);
		List<Predicate> predicates = new ArrayList<>();
		if (StringUtils.isNotBlank(filter.getConselho())) {
			predicates.add(builder.like(builder.lower(registoRoot.get("mensagem").get("conselho")),
					"%" + filter.getConselho().toLowerCase() + "%"));

		}
		criteriaQuery.select(registoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));

		// criteriaQuery.orderBy(builder.asc(registoRoot.get("nome")));

		TypedQuery<DocRegisto> query = manager.createQuery(criteriaQuery);

		return query.getResultList();
	}

	public DocRegisto porId(Long id) {
		return manager.find(DocRegisto.class, id);
	}

	@Transactional
	public void remover(DocRegisto docRegisto) {
		try {
			docRegisto = porId(docRegisto.getId());
			manager.remove(docRegisto);
			manager.flush();
		} catch (PersistenceException e) {
			FacesUtil.addErrorMessage("O registo não pode ser apagado");
		}

	}

}
