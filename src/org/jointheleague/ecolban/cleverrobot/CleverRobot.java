package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class CleverRobot extends IRobotAdapter {
	Sonar sonar = new Sonar();
	
	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while(rob.loop()){}
		rob.shutDown();
		
	}

	private void setup() throws Exception {
			driveDirect(100,100);
	}
	
	private boolean loop() throws Exception{
		readSensors(100);
		driveDirect(100,100);
		if(isLightBump()){
			driveDirect(-400,-400);
			Thread.sleep(1000);
			driveDirect(400,-400);
			Thread.sleep(1000);
		}
		

		/*if(isBumpLeft()){
			driveDirect(-200,400);
			Thread.sleep(1000);
			driveDirect(0,0);
		}
		else if(isBumpRight()){
			driveDirect(400,-200);
			Thread.sleep(1000);
			driveDirect(0,0);

		}
		else{
			driveDirect(101,100);
			Thread.sleep(1000);
		}*/
		
		driveDirect(100,100);

		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}
