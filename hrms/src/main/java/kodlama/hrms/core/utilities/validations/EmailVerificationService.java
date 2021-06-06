package kodlama.hrms.core.utilities.validations;

public interface EmailVerificationService<T> {
	public boolean CheckIfRealEmail(T entity);
}
