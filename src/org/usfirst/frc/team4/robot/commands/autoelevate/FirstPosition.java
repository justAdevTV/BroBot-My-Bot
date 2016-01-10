package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.commands.ClawClose;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FirstPosition extends CommandGroup {
    
    public FirstPosition() {
    	addSequential(new ClawClose());
    	addSequential(new SetHeight(-.32));
    }
}