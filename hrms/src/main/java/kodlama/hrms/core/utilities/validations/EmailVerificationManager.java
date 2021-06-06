package kodlama.hrms.core.utilities.validations;

public class EmailVerificationManager<T> implements EmailVerificationService<T> {

	@Override
	public boolean CheckIfRealEmail(T entity) {
		return true;
	}
}
