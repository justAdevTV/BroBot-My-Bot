package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.commands.ClawClose;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUp extends CommandGroup {
    
    public  PickUp() {
    	addSequential(new ClawClose());
    	//TODO Add actual increment
    	addSequential(new SetElevatorPos(0.5));
    }
}
