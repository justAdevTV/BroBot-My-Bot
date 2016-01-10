package org.usfirst.frc.team4.robot.commands.autoelevate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SecondPosition extends CommandGroup {
    
    public  SecondPosition() {
		addSequential(new SetHeight(-.34));
		addSequential(new SetHeight(-.28));    	
    }
}