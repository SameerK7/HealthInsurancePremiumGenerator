package com.emids.rulemanager;

import java.util.HashSet;
import java.util.Set;

import com.emids.entitymodels.Habits;

public interface HabitsDivided {
	
	@SuppressWarnings("serial")
	Set<Habits> badHabits = new HashSet<Habits>() {
		{
			add(Habits.SMOKING);
			add(Habits.ALCOHOL);
			add(Habits.DRUGS);
		}
	};
	
	@SuppressWarnings("serial")
	Set<Habits> goodHabits = new HashSet<Habits>() {
		{
			add(Habits.DAILYEXERCISE);
		}
	};
}
