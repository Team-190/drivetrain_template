/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drivetrain.DefaultDriveCommand;
import frc.robot.input.AttackThree;
import frc.robot.input.XboxOneController;
import frc.robot.subsystems.DrivetrainSubsystem;
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
  public final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();

  /*
   * Input
   */
  public final AttackThree leftStick =
          new AttackThree(Constants.InputConstants.LEFT_JOYSTICK_CHANNEL);
  public final AttackThree rightStick =
          new AttackThree(Constants.InputConstants.RIGHT_JOYSTICK_CHANNEL);
  public final XboxOneController driverXboxController =
          new XboxOneController(Constants.InputConstants.DRIVER_XBOX_CHANNEL);
  public final XboxOneController operatorXboxController =
          new XboxOneController(Constants.InputConstants.OPERATOR_XBOX_CHANNEL);

  /*
   * Input Methods (Change these to change how the robot works)
   */
  public DRIVE_STYLE currentDriveStyle = DRIVE_STYLE.ARCADE;
  public INPUT_METHOD driver_input_method = INPUT_METHOD.STICKS;
  public INPUT_METHOD operator_input_method = INPUT_METHOD.CONTROLLER;

  /*
   * Choosers for Drive Style and Input Modes
   */
  private static final SendableChooser<DRIVE_STYLE> driveStyleChooser = new SendableChooser<>();
  private static final SendableChooser<INPUT_METHOD> driverInputChooser = new SendableChooser<>();
  private static final SendableChooser<INPUT_METHOD> operatorInputChooser = new SendableChooser<>();

  /**
   * Constructor for the robot container
   *     Called when the Rio is powered on, and is only called once. We use this to configure commands from buttons
   */
  public RobotContainer() {

// Configure the button bindings for the driver
    configureStickBindings();
    configureDriverController();

    // Configure the button bindings for the operator
    configureButtonBox();
    configureOperatorController();

    // Set the Default Commands for the subsystems
    setDefaultCommands();

    SmartDashboard.putString("Drive Style", currentDriveStyle.toString());
    SmartDashboard.putString("Control Scheme", driver_input_method.toString());

    createInputChoosers();
  }

  /** These methods binds commands to button and sticks */
  private void configureDriverController() {

  }

  private void configureStickBindings() {

  }

  private void configureOperatorController() {

  }

  private void configureButtonBox() {

  }

  public void createInputChoosers() {

    // Drive Style
    driveStyleChooser.addOption("Tank Drive", DRIVE_STYLE.TANK);
    driveStyleChooser.addOption("Arcade", DRIVE_STYLE.ARCADE);
    driveStyleChooser.addOption("Curvature", DRIVE_STYLE.MCFLY);
    driveStyleChooser.setDefaultOption(currentDriveStyle.toString(), currentDriveStyle);

    // Driver Input
    driverInputChooser.addOption("Sticks", INPUT_METHOD.STICKS);
    driverInputChooser.addOption("Controller", INPUT_METHOD.CONTROLLER);
    driverInputChooser.setDefaultOption(driverInputChooser.toString(), driver_input_method);

    // Operator Input
    operatorInputChooser.addOption("Button Box", INPUT_METHOD.BUTTON_BOX);
    operatorInputChooser.addOption("Controller", INPUT_METHOD.CONTROLLER);
    operatorInputChooser.setDefaultOption(operator_input_method.toString(), operator_input_method);

    SmartDashboard.putData("Drive Style", driveStyleChooser);
    SmartDashboard.putData("Driver Input", driverInputChooser);
    SmartDashboard.putData("Operator Input", operatorInputChooser);
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
    drivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(this));
  }

  /**
   * Get the currently chosen Drive Style
   *
   * @return The currently selected driver style
   */
  public DRIVE_STYLE getSelectedDriveStyle() {
    return driveStyleChooser.getSelected();
  }

  /**
   * Get the currently chosen driver input
   *
   * @return the currently selected driver input
   */
  public INPUT_METHOD getSelectedDriverInput() {
    return driverInputChooser.getSelected();
  }

  /**
   * Get the currently chosen operator input
   *
   * @return the currently selected operator input
   */
  public INPUT_METHOD getSelectedOperatorInput() {
    return operatorInputChooser.getSelected();
  }


}
