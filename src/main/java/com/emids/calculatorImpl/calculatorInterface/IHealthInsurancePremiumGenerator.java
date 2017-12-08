/**
 * 
 */
package com.emids.calculatorImpl.calculatorInterface;

import com.emids.entitymodels.Person;

/**
 * @author Sameer Kulkarni
 * 
 * This interface provides an abstract API
 * to call calculation methods to generate
 * health insurance premium
 *
 */
public interface IHealthInsurancePremiumGenerator {
	
	public double calculateHealthInsurancePremium(Person person);

}
