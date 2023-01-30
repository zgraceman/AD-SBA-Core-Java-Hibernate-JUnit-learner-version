/**
 * 
 */
package sba.sms.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sba.sms.models.Course;

/**
 * @author zachg
 *
 */
class CourseServiceTest {
	
	static Course testCourse = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		testCourse = new Course(7, "Finance 101", "Zach", null);
	
	}

	@Test
	@DisplayName("Testing getId function with Course")
	void test() {
		
		assertThat(7).isEqualTo(testCourse.getId());
		
	}

}
