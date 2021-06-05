package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;
	
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	
	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}

	@Override
	public DataResult<Link> get(int id) {
		Optional<Link> link=this.linkDao.findById(id);
		return new SuccessDataResult<Link>(link.get());
	}

	@Override
	public Result add(Link entity) {
		this.linkDao.save(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result delete(Link entity) {
		this.linkDao.delete(entity);
		return new SuccessResult(true);
	}

	@Override
	public Result update(Link entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
