package com.bappli.redmine.timer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TimerWindow
{

	protected Shell shell;
	private static TimerWindow timerWindow; 

	//----------------------------------------------------------------------------------- TimerWindow
	private TimerWindow()
	{
	}

	//-------------------------------------------------------------------------------- createContents
	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shell = new Shell();
		shell.setBounds(0, 0, 400, 200);
		shell.setText("Redmine Timer");
	}

	//----------------------------------------------------------------------------------------- focus
	public static TimerWindow focus()
	{
		if (timerWindow == null) {
			timerWindow = new TimerWindow();
			timerWindow.open();
		} else {
			timerWindow.shell.setFocus();
		}
		return timerWindow;
	}

	//------------------------------------------------------------------------------------------ open
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public TimerWindow open()
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return this;
	}

}
