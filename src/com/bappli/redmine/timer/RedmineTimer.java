package com.bappli.redmine.timer;

public class RedmineTimer
{

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try {
			SystemTrayAccess.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
