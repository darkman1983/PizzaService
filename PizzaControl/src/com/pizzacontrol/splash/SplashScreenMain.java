package com.pizzacontrol.splash;

import javax.swing.ImageIcon;

public class SplashScreenMain {

	SplashScreen screen;

	public SplashScreenMain() {
		// initialize the splash screen
		splashScreenInit();
		// do something here to simulate the program doing something that
		// is time consuming
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// run either of these two -- not both
			screen.setProgress("Lade... " + i, i); // progress bar with a
													// message
			// screen.setProgress(i); // progress bar with no message
		}
		splashScreenDestruct();
	}

	private void splashScreenDestruct() {
		screen.setScreenVisible(false);
	}

	private void splashScreenInit() {
		ImageIcon myImage = new ImageIcon(this.getClass().getResource("images/splash2.gif"));
		screen = new SplashScreen(myImage);
		screen.setLocationRelativeTo(null);
		screen.setProgressMax(100);
		screen.setScreenVisible(true);
	}
}