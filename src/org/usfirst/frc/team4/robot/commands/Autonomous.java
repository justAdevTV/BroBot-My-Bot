package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.commands.autoelevate.FifthPosition;
import org.usfirst.frc.team4.robot.commands.autoelevate.FirstPosition;
import org.usfirst.frc.team4.robot.commands.autoelevate.FourthPosition;
import org.usfirst.frc.team4.robot.commands.autoelevate.PrePickUp;
import org.usfirst.frc.team4.robot.commands.autoelevate.SecondPosition;
import org.usfirst.frc.team4.robot.commands.autoelevate.ThirdPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	public Autonomous() {
		// addSequential(new TurnInPlace(10));
		//addSequential(new DriveStraight(12));
		addSequential(new PrePickUp());
		//addSequential(new Wait(1));
		addSequential(new FirstPosition());
		//addSequential(new Wait(1));
		addSequential(new SecondPosition());
		//addSequential(new Wait(1));
		addSequential(new ThirdPosition());
		//addSequential(new Wait(1));
		addSequential(new FourthPosition());
		//addSequential(new Wait(1));
		addSequential(new FifthPosition());
		//addSequential(new Wait(1));
	}
}