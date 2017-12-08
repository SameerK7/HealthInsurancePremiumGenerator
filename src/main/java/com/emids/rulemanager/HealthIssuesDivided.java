/**
 * 
 */
package com.emids.rulemanager;

import java.util.HashSet;
import java.util.Set;

import com.emids.entitymodels.HealthIssues;

/**
 * @author emidstest04
 *
 */
public interface HealthIssuesDivided {
	
	@SuppressWarnings("serial")
	Set<HealthIssues> existingHealthIssues = new HashSet<HealthIssues>() {
		{
			add(HealthIssues.OVERWEIGHT);
		}
	};
	
	@SuppressWarnings("serial")
	Set<HealthIssues> nonExistingHealthIssues = new HashSet<HealthIssues>() {
		{
			add(HealthIssues.HYPERTENSION);
			add(HealthIssues.BLOODPRESSURE);
			add(HealthIssues.BLOODSUGAR);
		}
	};

}
