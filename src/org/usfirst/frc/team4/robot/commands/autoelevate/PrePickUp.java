package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.commands.ClawOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrePickUp extends CommandGroup {
    
    public  PrePickUp() {
    	addSequential(new ClawOpen());
    	//TODO add actual pos
    	addSequential(new SetElevatorPos(0));
    }
}
