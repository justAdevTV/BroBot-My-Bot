package org.usfirst.frc.team4.robot;

import org.usfirst.frc.team4.robot.commands.ArmToggle;
import org.usfirst.frc.team4.robot.commands.ClawToggle;
import org.usfirst.frc.team4.robot.commands.ToggleDrive;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {

	public OI() {
		RobotMap.opA.whenPressed(new ClawToggle());
		RobotMap.opB.whenPressed(new ArmToggle());
		RobotMap.opL3.whenPressed(new ToggleDrive());
	}

	public double rightX(Joystick cont){
		double v = (cont.getRawAxis(RobotMap.CONT_RX));
		v = squareNum(v);
		v = fixLimit(v);
		return v;
	}
	
	public double rightY(Joystick cont) {
		double v = (cont.getRawAxis(RobotMap.CONT_RY));
		v = squareNum(v);
		v = fixLimit(v);
		return v;
	}

	public double leftY(Joystick cont) {
		//Squared to make driving smoother
		double v = (cont.getRawAxis(RobotMap.CONT_LY));
		v = squareNum(v);
		v = fixLimit(v);
		return v;
	}
	
	//Prevents unwanted movement
	public double fixLimit(double v){
		if (v > -.1 || v < .1){
			return 0;
		} else if (v > .9){
			return 1;
		} else if (v < -.9){
			return -1;
		} else {
			return v;
		}
	}
	
	//Squared to make driving smoother
	public double squareNum(double v){
		return (v*Math.abs(v));
	}
}