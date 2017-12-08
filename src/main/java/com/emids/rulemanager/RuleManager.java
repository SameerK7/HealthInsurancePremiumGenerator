/**
 * 
 */
package com.emids.rulemanager;

import com.emids.entitymodels.Gender;
import com.emids.entitymodels.Habits;
import com.emids.entitymodels.HealthIssues;
import com.emids.entitymodels.Person;

/**
 * @author Sameer Kulkarni
 * 
 *         This class manages about the rules to be applied for person while
 *         calculating of premium
 *
 */
public class RuleManager {

	public static double applyBadHabitsBasedCalculation(Person person, double premium) {
		// Increase 3% per good habit
		for (Habits habit : person.getHabits()) {
			if (HabitsDivided.badHabits.contains(habit)) {
				premium *= 1.03;
			}
		}
		return premium;
	}

	public static double applyGoodHabitsBasedCalculation(Person person, double premium) {
		// Decrease 3% per good habit
		for (Habits habit : person.getHabits()) {
			if (HabitsDivided.goodHabits.contains(habit)) {
				premium *= 0.97;
			}
		}
		return premium;
	}

	@SuppressWarnings("unused")
	public static double applyHealthIssuesBasedCalculation(Person person, double premium) {
		// Increase 1% per health issue
		for (HealthIssues issue : person.getHealthIssues()) {
			//if(HealthIssuesDivided.existingHealthIssues.contains(issue))
			premium *= 1.01;
		}
		return premium;
	}

	public static double applyGenderBasedCalculation(Person person, double premium) {
		// Add gender specific adjustments
		if (person.getGender() == Gender.MALE) {
			premium *= 1.02;
		}
		return premium;
	}

	public static double applyAgeBasedCalculation(Person person, double premium) {
		// Increase premium by age wise
		if (person.getAge() >= 18) {
			premium *= 1.1;
		}
		if (person.getAge() >= 25) {
			premium *= 1.1;
		}
		if (person.getAge() >= 30) {
			premium *= 1.1;
		}
		if (person.getAge() >= 35) {
			premium *= 1.1;
		}
		if (person.getAge() >= 40) {
			// 20% per 5 years above 40
			double age = person.getAge() - 40;
			while (age >= 5) {
				premium *= 1.2;
				age -= 5;
			}
		}
		return premium;
	}
}
