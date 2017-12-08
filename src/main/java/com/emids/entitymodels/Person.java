/**
 * 
 */
package com.emids.entitymodels;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sameer Kulkarni
 * This class describes about Person properties/details.
 *
 */
public class Person {

	private String personName;
	private Gender gender;
	private double age;
	private Set<Habits> habits;
	private Set<HealthIssues> healthIssues;

	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public Set<Habits> getHabits() {
		if(habits == null) {
			habits = new HashSet<Habits>();
		}
		return habits;
	}
	public void setHabits(Set<Habits> habits) {
		this.habits = habits;
	}
	public Set<HealthIssues> getHealthIssues() {
		if (healthIssues == null) {
			healthIssues = new HashSet<HealthIssues>();
		}
		return healthIssues;
	}
	public void setHealthIssues(Set<HealthIssues> healthIssues) {
		this.healthIssues = healthIssues;
	}

}
