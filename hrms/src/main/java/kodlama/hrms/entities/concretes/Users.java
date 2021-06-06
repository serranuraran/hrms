package kodlama.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@Entity
	@Table(name="users")
	@AllArgsConstructor
	@NoArgsConstructor
	public class Users {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="user_id")
		private int userId;

		@Column(name="first_name")
		private String firstName;

		@Column(name="last_name")
		private String lastName;

		@Column(name="identity_number")
		private String identityNumber;

		@Column(name="email")
		private String email;

		@Column(name="birth_year")
		private Date birthYear;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getIdentityNumber() {
			return identityNumber;
		}

		public void setIdentityNumber(String identityNumber) {
			this.identityNumber = identityNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getBirthYear() {
			return birthYear;
		}

		public void setDateOfBirth(Date birthYear) {
			this.birthYear = birthYear;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name="password")
		private String password;
	}