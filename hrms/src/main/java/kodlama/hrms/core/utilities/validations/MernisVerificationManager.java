package kodlama.hrms.core.utilities.validations;

public class MernisVerificationManager<T> implements MernisVerificationService<T> {

	@Override
	public boolean CheckIfRealPerson(T entity) {
		return true;
	}

}
