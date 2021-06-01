package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.business.constants.ErrorMessages;
import kodlamaio.hrms.business.constants.SuccessMessages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemStaff;

@Service
public class SystemStaffManager implements SystemStaffService {

	private SystemStaffDao systemStaffDao;

	@Autowired
	public SystemStaffManager(SystemStaffDao systemStaffDao) {
		super();
		this.systemStaffDao = systemStaffDao;
	}

	@Override
	public DataResult<List<SystemStaff>> getAll() {
		return new SuccessDataResult<List<SystemStaff>>(systemStaffDao.findAll(), SuccessMessages.systemStaffListed);
	}

	@Override
	public DataResult<SystemStaff> get(int id) {
		Optional<SystemStaff> systemStaff = this.systemStaffDao.findById(id);
		if (!systemStaff.isPresent()) {
			return new ErrorDataResult<SystemStaff>(systemStaff.get(), ErrorMessages.couldntSystemStaffListed);
		}
		return new SuccessDataResult<SystemStaff>(systemStaff.get());
	}

	@Override
	public Result add(SystemStaff entity) {
		var result = BusinessRules.run(isEmpty(entity));
		if (result!=null) {
			return result;
		}

		systemStaffDao.save(entity);
		return new SuccessResult(SuccessMessages.systemStaffAdded);
	}

	@Override
	public Result delete(SystemStaff entity) {
		Optional<SystemStaff> systemStaff = this.systemStaffDao.findById(entity.getId());
		if (systemStaff.isPresent()) {
			this.systemStaffDao.delete(systemStaff.get());
			return new SuccessResult(SuccessMessages.systemStaffDeleted);
		}
		return new ErrorResult(ErrorMessages.couldntSystemStaffDeleted);
	}

	@Override
	public Result update(SystemStaff entity) {
		Optional<SystemStaff> systemStaff = this.systemStaffDao.findById(entity.getId());
		if (systemStaff.isPresent()) {

			SystemStaff systemStaffUpdate = systemStaff.get();


			systemStaffUpdate.setFirsName(entity.getFirsName());
			systemStaffUpdate.setLastName(entity.getLastName());
			systemStaffUpdate.setEmail(entity.getEmail());
			systemStaffUpdate.setPassword(entity.getPassword());

			systemStaffDao.save(systemStaffUpdate);

			return new SuccessResult(SuccessMessages.systemStaffUpdated);
		}
		return new ErrorResult(ErrorMessages.couldntSystemStaffUpdated);
	}

	private Result isEmpty(SystemStaff systemStaff) {
		if (systemStaff.getFirsName() == null || systemStaff.getLastName()== null || systemStaff.getEmail() == null
				|| systemStaff.getPassword() == null) {
			return new ErrorResult(ErrorMessages.userIsEmpty);
		}

		return new SuccessResult(true);

	}

}
