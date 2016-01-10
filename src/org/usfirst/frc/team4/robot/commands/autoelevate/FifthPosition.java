package org.usfirst.frc.team4.robot.commands.autoelevate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FifthPosition extends CommandGroup {
    
    public  FifthPosition() {
		addSequential(new SetHeight(-.22));
		addSequential(new SetHeight(-.16));
    }
}
