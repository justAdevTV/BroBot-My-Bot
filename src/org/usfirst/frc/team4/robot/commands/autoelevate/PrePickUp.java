package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.commands.ClawOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrePickUp extends CommandGroup {
    
    public PrePickUp() {
    	addSequential(new ClawOpen());
    	addSequential(new SetHeight(-.39));
    }
}