package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.commands.ClawOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Place extends CommandGroup {
    
    public  Place() {
    	//TODO Add actual value
        addSequential(new SetElevatorPos(.25));
        addSequential(new ClawOpen());
    }
}
