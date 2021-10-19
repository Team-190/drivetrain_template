package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.input.AttackThree;
import frc.robot.input.XboxOneController;
import frc.robot.subsystems.DrivetrainSubsystem;

/** Default Drive Command */
public class DefaultDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;

    private final AttackThree leftStick;
    private final AttackThree rightStick;
    private final XboxOneController driverXbox;

    private final Constants.InputConstants.INPUT_METHOD input_method;
    private final Constants.DrivetrainConstants.DRIVE_STYLE currentDriveStyle;

    public DefaultDriveCommand(RobotContainer robotContainer) {
        this.leftStick = robotContainer.leftStick;
        this.rightStick = robotContainer.rightStick;
        this.driverXbox = robotContainer.driverXboxController;

        this.drivetrainSubsystem = robotContainer.drivetrainSubsystem;

        this.input_method = robotContainer.driver_input_method;
        this.currentDriveStyle = robotContainer.currentDriveStyle;

        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {}

    /**
     * Take the values from the controllers and the current styles in the robot container and set the
     * drive based upon it
     */
    public void execute() {

        double throttleLeftValue = 0.0;
        double rotationRightValue = 0.0;
        boolean squareQuickTurn = true;

        switch (input_method) {
            case STICKS:
                if (currentDriveStyle == Constants.DrivetrainConstants.DRIVE_STYLE.ARCADE
                        || currentDriveStyle == Constants.DrivetrainConstants.DRIVE_STYLE.MCFLY) {
                    throttleLeftValue = leftStick.getY();
                    rotationRightValue = rightStick.getX();
                } else {
                    throttleLeftValue = rightStick.getY();
                    rotationRightValue = leftStick.getY();
                }
                break;
            case CONTROLLER:
                // driverXboxController.getRawAxis(0) // Left side x axis
                throttleLeftValue = driverXbox.getLeftStickY(); // Left side Y axis
                rotationRightValue = driverXbox.getRightStickX(); // Right side X axis
                // driverXboxController.getRawAxis(3) // Right side Y axis
                squareQuickTurn = driverXbox.getLeftBumper();
                break;
            case KINECT:
                // Bruh, I'm not sure
                break;
        }

        switch (currentDriveStyle) {
            case ARCADE:
                drivetrainSubsystem.arcadeDrive(throttleLeftValue, rotationRightValue, true);
                break;
            case TANK:
                drivetrainSubsystem.westCoastDrive(throttleLeftValue, rotationRightValue, false);
                break;
            case MCFLY:
                squareQuickTurn = rightStick.getTopPressed();
                drivetrainSubsystem.curvatureDrive(throttleLeftValue, rotationRightValue, squareQuickTurn);
                break;
        }
    }

    /** At the end, stop the drivetrain. */
    public void end(boolean interrupted) {
        drivetrainSubsystem.arcadeDrive(0.0, 0.0, false);
    }
}