/**
 * 
 */
package com.emids.calculatorImpl;

import com.emids.calculatorImpl.calculatorInterface.IHealthInsurancePremiumGenerator;
import com.emids.entitymodels.Person;
import com.emids.rulemanager.RuleManager;

/**
 * @author Sameer Kulkarni
 * 
 * This class implements all health insurance premium
 * calculation strategy of person
 *
 */
public class HealthInsurancePremiumGeneratorImpl implements IHealthInsurancePremiumGenerator {

	public double calculateHealthInsurancePremium(Person person) {
		// The Base Premium Mentioned is given below
		double premium = 5000;
		premium = RuleManager.applyAgeBasedCalculation(person, premium);
		premium = RuleManager.applyGenderBasedCalculation(person, premium);
		premium = RuleManager.applyHealthIssuesBasedCalculation(person, premium);
		premium = RuleManager.applyGoodHabitsBasedCalculation(person, premium);
		premium = RuleManager.applyBadHabitsBasedCalculation(person, premium);
		return premium;
	}

}
