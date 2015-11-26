package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmToggle extends Command {

    public ArmToggle() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.pneumatics.isArmOpen){
    		Robot.pneumatics.armClose();
    	} else{
    		Robot.pneumatics.armOpen();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.isArmOpen = !Robot.pneumatics.isArmOpen;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}