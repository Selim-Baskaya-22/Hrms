package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.constants.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(), SuccessMessages.cityListed);
	}

	@Override
	public DataResult<City> get(int id) {
		Optional<City> city = this.cityDao.findById(id);
		return new SuccessDataResult<City>(city.get(), SuccessMessages.cityListed);
	}

	@Override
	public Result add(City entity) {
		this.cityDao.save(entity);
		return new SuccessResult(SuccessMessages.cityAdded);
	}

	@Override
	public Result delete(City entity) {
		this.cityDao.delete(entity);
		return new SuccessResult(SuccessMessages.cityDeleted);
	}

	@Override
	public Result update(City entity) {
		
		Optional<City> city = this.cityDao.findById(entity.getId());

		City cityUpdate = city.get();

		cityUpdate.setCityName(entity.getCityName());

		cityDao.save(cityUpdate);

		return new SuccessResult(SuccessMessages.cityUpdated);

	}

}
