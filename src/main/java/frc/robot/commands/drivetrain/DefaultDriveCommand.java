package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.input.AttackThree;
import frc.robot.subsystems.Drivetrain;

/** Default Drive Command */
public class DefaultDriveCommand extends CommandBase {
    private final Drivetrain drivetrain;

    private final AttackThree leftStick;
    private final AttackThree rightStick;
    private final XboxController driverXbox;

    private final Constants.InputConstants.INPUT_METHOD input_method;
    private final Constants.DrivetrainConstants.DRIVE_STYLE currentDriveStyle;

    public DefaultDriveCommand(RobotContainer robotContainer) {
        this.leftStick = robotContainer.leftStick;
        this.rightStick = robotContainer.rightStick;
        this.driverXbox = robotContainer.driverXboxController;

        this.drivetrain = robotContainer.drivetrain;

        this.input_method = robotContainer.input_method;
        this.currentDriveStyle = robotContainer.currentDriveStyle;

        addRequirements(drivetrain);
    }

    public void initialize() {
    }

    /**
     * Take the values from the controllers and the current styles in the robot container and set the drive based upon it
     */
    public void execute() {

        double throttleLeftValue = 0.0;
        double rotationRightValue = 0.0;
        boolean squareQuickTurn = true;

        switch (input_method) {
            case STICKS:
                throttleLeftValue = leftStick.getY();
                if (currentDriveStyle == Constants.DrivetrainConstants.DRIVE_STYLE.ARCADE || currentDriveStyle == Constants.DrivetrainConstants.DRIVE_STYLE.CURVATURE) {
                    rotationRightValue = rightStick.getX();
                } else {
                    rotationRightValue = rightStick.getY();
                }
                squareQuickTurn = rightStick.getTrigger();
                break;
            case CONTROLLER:
                // driverXboxController.getRawAxis(0) // Left side x axis
                throttleLeftValue = driverXbox.getRawAxis(1); // Left side Y axis
                rotationRightValue = driverXbox.getRawAxis(2); // Right side X axis
                // driverXboxController.getRawAxis(3) // Right side Y axis
                squareQuickTurn = driverXbox.getBumper(GenericHID.Hand.kLeft);
                break;
            case KINECT:
                // Bruh, I'm not sure
                break;
        }

        switch (currentDriveStyle) {
            case ARCADE:
                drivetrain.arcadeDrive(throttleLeftValue, rotationRightValue, true);
                break;
            case TANK:
                drivetrain.westCoastDrive(throttleLeftValue, rotationRightValue, true);
                break;
            case CURVATURE:
                drivetrain.curvatureDrive(throttleLeftValue, rotationRightValue, squareQuickTurn);
                break;
        }
    }

    /** At the end, stop the drivetrain. */
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0.0, 0.0, false);
    }
}