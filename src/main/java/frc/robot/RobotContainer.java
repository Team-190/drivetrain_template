/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.drivetrain.DefaultDriveCommand;
import frc.robot.input.AttackThree;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Constants.DrivetrainConstants.DRIVE_STYLE;
import frc.robot.Constants.InputConstants.INPUT_METHOD;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /*
   * Subsystems
   */
  public final Drivetrain drivetrain = new Drivetrain();

  /*
   * Input
   */
  public final AttackThree leftStick = new AttackThree(Constants.InputConstants.LEFT_JOYSTICK_CHANNEL);
  public final AttackThree rightStick = new AttackThree(Constants.InputConstants.RIGHT_JOYSTICK_CHANNEL);
  public final XboxController driverXboxController = new XboxController(Constants.InputConstants.DRIVER_XBOX_CHANNEL);

  /*
   * Input Methods (Change these to change how the robot works)
   */
  public DRIVE_STYLE currentDriveStyle = DRIVE_STYLE.TANK;
  public INPUT_METHOD input_method = INPUT_METHOD.STICKS;

  /**
   * Constructor for the robot container
   *     Called when the Rio is powered on, and is only called once. We use this to configure commands from buttons
   */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();

    // Set the Default Commands for the subsystems
    setDefaultCommands();
  }

  /**
   * This method binds commands to button and sticks
   */
  private void configureButtonBindings() {

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
      return null; // TODO get a basic command that goes forward for one second
  }

  public void setDefaultCommands() {

      // Default drive command
      drivetrain.setDefaultCommand(new DefaultDriveCommand(this));
  }


}
