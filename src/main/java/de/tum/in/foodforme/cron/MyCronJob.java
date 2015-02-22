package de.tum.in.foodforme.cron;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import de.tum.in.foodforme.model.Recipe;

public class MyCronJob extends QuartzJobBean{

	private Recipe myRecipe;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("I'm running with r:"+ myRecipe.toString());
	}
}
