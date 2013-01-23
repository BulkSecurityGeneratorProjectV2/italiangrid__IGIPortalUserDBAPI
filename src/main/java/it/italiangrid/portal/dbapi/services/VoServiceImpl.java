package it.italiangrid.portal.dbapi.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.italiangrid.portal.dbapi.dao.generic.VoDAO;
import it.italiangrid.portal.dbapi.domain.Vo;

@Service
public class VoServiceImpl implements VoService {

	private static final Logger log = Logger
			.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private VoDAO voDAO;

	@Transactional
	public List<Vo> getAllVo() {
		log.debug("getting all Vo instance");
		return voDAO.findAll();
	}

	@Transactional
	public Vo findById(Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		return voDAO.findById(id,false);
	}

	@Transactional
	public String findByVo(Vo vo) {
		log.debug("getting Vo instance");
		return voDAO.findById(vo.getIdVo(),false).getVo();
	}

	@Transactional
	public List<String> getAllDiscplines() {
		return voDAO.getAllDiscipline();
	}

	@Transactional
	public List<Vo> getAllVoByName(String search) {
		return voDAO.findAll(search);
	}

	@Transactional
	public Vo findByName(String search) {
		return voDAO.findByName(search);
	}
	
	@Transactional
	public void save(Vo vo) {
		voDAO.makePersistent(vo);
		
	}
	
	@Transactional
	public void delete(Integer id) {
		Vo vo = voDAO.findById(id,false);
		voDAO.makeTransient(vo);
	}

}
