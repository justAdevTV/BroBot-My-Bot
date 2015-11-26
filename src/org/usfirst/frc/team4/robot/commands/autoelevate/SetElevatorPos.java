package org.usfirst.frc.team4.robot.commands.autoelevate;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetElevatorPos extends Command {

	private double setPos;
	
    public SetElevatorPos(double setPos) {
        this.setPos = setPos;
    	requires(Robot.Pelevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Pelevator.enable();
    	Robot.Pelevator.setSetpoint(setPos);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.Pelevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
