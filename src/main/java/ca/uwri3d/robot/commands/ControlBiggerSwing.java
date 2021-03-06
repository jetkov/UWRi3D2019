package ca.uwri3d.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.XboxController;
import ca.uwri3d.robot.Robot;

/**
 *
 */
public class ControlBiggerSwing extends Command {

	private XboxController controller;
	private int controllerAxis;

	public ControlBiggerSwing(XboxController inController, int inAxis) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.biggerSwing);

		controller = inController;
		controllerAxis = inAxis;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		controller = Robot.io.getOperatorController();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.biggerSwing.setSpeed(-controller.getRawAxis(controllerAxis) * 0.40);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.biggerSwing.setSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
