package sba.sms.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Student {

	@Id
	@NonNull
	@Column(length = 50, name = "email")
	String email;
	
	@NonNull
	@Column(length = 50, name = "name")  // varchar(50) variable for sql
	String name;
	
	@NonNull
	@Column(length = 50, name = "password")
	String password;
	
	@ToString.Exclude
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
	fetch = FetchType.EAGER)  // Cascade all EXCEPT remove
	
	@JoinTable(name = "student_courses", 
	joinColumns = @JoinColumn(name = "student_email"),
	inverseJoinColumns = @JoinColumn(name = "courses_id"))
	List<Course> courses = new LinkedList();
	
	
	// Methods
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
	public void addCourse(Course c) {
		courses.add(c);
		c.getStudents().add(this);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, name, password);
	}
	
	
}
	

