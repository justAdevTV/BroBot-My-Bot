package org.usfirst.frc.team4.robot.commands.autoelevate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThirdPosition extends CommandGroup {
    
    public  ThirdPosition() {
		addSequential(new SetHeight(-.30));
		addSequential(new SetHeight(-.24));
    }
}
