package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.ClawClose;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class PickUp extends CommandGroup {

	private Potentiometer m_pot = new AnalogPotentiometer(
			RobotMap.ELEVATOR_POTENTIOMETER, -.4);
	
	private double pos = m_pot.get();

	public PickUp() {
		addSequential(new ClawClose());
		// TODO Create Multiple Classes
		//addSequential(new SetElevatorPos(pos + .08));
		addSequential(new SetElevatorPos(pos - .02));
		addSequential(new SetElevatorPos(pos + .06));
	}
}