/**
 * 
 */
package com.emids.calculatorImpl;

import java.util.Set;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import com.emids.calculatorImpl.calculatorInterface.IHealthInsurancePremiumGenerator;
import com.emids.entitymodels.Gender;
import com.emids.entitymodels.Habits;
import com.emids.entitymodels.HealthIssues;
import com.emids.entitymodels.Person;

/**
 * @author Sameer Kulkarni
 * 
 * This class tests cases of Health Insurance Premium Generator
 *
 */
public class HealthInsurancePremiumGeneratorTest {

	private IHealthInsurancePremiumGenerator generator = new HealthInsurancePremiumGeneratorImpl();

	@Test
	public void testCalculatePremiumForNormanGomes() throws Exception {
		Person person = new Person();
		person.setPersonName("Norman Gomes");
		person.setGender(Gender.MALE);
		person.setAge(34);
		Set<HealthIssues> issues = person.getHealthIssues();
		issues.add(HealthIssues.OVERWEIGHT);
		Set<Habits> habits = person.getHabits();
		habits.add(Habits.ALCOHOL);
		habits.add(Habits.DAILYEXERCISE);

		double premium = generator.calculateHealthInsurancePremium(person);

		assertThat(premium, closeTo(6856d, 10d));
	}

	@Test
	public void testCalculatePremiumForOldAge() throws Exception {
		Person person = new Person();
		person.setPersonName("Ajji");
		person.setGender(Gender.FEMALE);
		person.setAge(88);
		person.getHabits().add(Habits.DAILYEXERCISE);

		double premium = generator.calculateHealthInsurancePremium(person);

		assertThat(premium, closeTo(36639d, 1d));
	}

	@Test
	public void testCalculatePremiumForSubstanceAbuseTeenager() throws Exception {
		Person person = new Person();
		person.setPersonName("Yuvaka");
		person.setGender(Gender.MALE);
		person.setAge(23);
		Set<Habits> habits = person.getHabits();
		habits.add(Habits.DRUGS);
		habits.add(Habits.SMOKING);
		habits.add(Habits.ALCOHOL);
		Set<HealthIssues> healthIssues = person.getHealthIssues();
		healthIssues.add(HealthIssues.OVERWEIGHT);

		double premium = generator.calculateHealthInsurancePremium(person);

		assertThat(premium, closeTo(6191d, 1d));
	}

}
