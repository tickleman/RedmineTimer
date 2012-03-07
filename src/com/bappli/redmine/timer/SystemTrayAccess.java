package com.bappli.redmine.timer;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SystemTrayAccess
{

	//------------------------------------------------------------------------------------------ init
	public static void init()
	{
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			final Image image = Toolkit.getDefaultToolkit().getImage(
				SystemTrayAccess.class.getResource("images/timer.png")
			);
			PopupMenu popup = new PopupMenu();
			MenuItem item = new MenuItem("Quitter");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			});
			popup.add(item);
			final TrayIcon trayIcon = new TrayIcon(image, "Redmine Timer", popup);
			trayIcon.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent event)
				{
					if (event.getButton() == MouseEvent.BUTTON1) {
						new Runnable() {
							@Override
							public void run()
							{
								TimerWindow.focus();
							}
						}.run();
					}
				}
				@Override
				public void mouseEntered(MouseEvent event)
				{
				}
				@Override
				public void mouseExited(MouseEvent event)
				{
				}
				@Override
				public void mousePressed(MouseEvent event)
				{
				}
				@Override
				public void mouseReleased(MouseEvent event)
				{
				}
			});
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("Impossible de créer l'icône dans la barre de notification");
			}
		} else {
			System.err.println("Pas de barre de notification sur votre système");
		}
	}

}
