package org.usfirst.frc.team4.robot.commands.autoelevate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FourthPosition extends CommandGroup {
    
    public  FourthPosition() {
		addSequential(new SetHeight(-.26));
		addSequential(new SetHeight(-.20));
    }
}
