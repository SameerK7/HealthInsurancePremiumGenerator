/**
 * 
 */
package com.emids.rulemanager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;

import com.emids.entitymodels.Habits;
import com.emids.entitymodels.Person;

/**
 * @author Sameer Kulkarni
 * 
 * This class tests use cases of RuleManager defined in Rule Manager
 *
 */
public class RuleManagerTest {

	@Test
	public void testApplyBadHabitsBasedCalculationWithNoHabits() throws Exception {
		double premium = RuleManager.applyBadHabitsBasedCalculation(new Person(), 100d);
		assertThat(premium, closeTo(100d, 0.01d));
	}

	@Test
	public void testApplyBadHabitsBasedCalculationWithSomeBadHabits() throws Exception {
		Person person = new Person();
		person.getHabits().add(Habits.ALCOHOL);
		person.getHabits().add(Habits.SMOKING);
		double premium = RuleManager.applyBadHabitsBasedCalculation(person, 100d);
		assertThat(premium, closeTo(106.09d, 0.01d));
	}

	@Test
	public void testApplyBadHabitsBasedCalculationWithMixOfGoodAndBadHabits() throws Exception {
		Person person = new Person();
		person.getHabits().add(Habits.ALCOHOL);
		person.getHabits().add(Habits.DAILYEXERCISE);
		double premium = RuleManager.applyBadHabitsBasedCalculation(person, 100d);
		assertThat(premium, closeTo(103d, 0.01d));
	}

	@Test
	public void testApplyBadHabitsBasedCalculationNoBadHabits() throws Exception {
		Person person = new Person();
		person.getHabits().add(Habits.DAILYEXERCISE);
		double premium = RuleManager.applyBadHabitsBasedCalculation(person, 100d);
		assertThat(premium, closeTo(100d, 0.01d));
	}

	@Test
	public void testApplyAgeBasedCalculationWithLessThanEighteenAge() throws Exception {
		double premium = RuleManager.applyAgeBasedCalculation(new Person(), 100d);
		assertThat(premium, closeTo(100d, 0.01d));
	}

	@Test
	public void testApplyAgeBasedCalculationWithAgeThirtyFour() throws Exception {
		Person person = new Person();
		person.setAge(34);
		double premium = RuleManager.applyAgeBasedCalculation(person, 100d);
		assertThat(premium, closeTo(133.1d, 0.01d));
	}

	@Test
	public void testApplyAgeBasedCalculationWithAgeEightyEight() throws Exception {
		Person person = new Person();
		person.setAge(88);
		double premium = RuleManager.applyAgeBasedCalculation(person, 100d);
		assertThat(premium, closeTo(755.44d, 0.01d));
	}}
