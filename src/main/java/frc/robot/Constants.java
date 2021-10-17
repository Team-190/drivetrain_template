package frc.robot;

import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;

public final class Constants {

    public static final ShuffleboardTab DRIVER_TAB = Shuffleboard.getTab("DriverTab");

    public static final class InputConstants {
        public static final int LEFT_JOYSTICK_CHANNEL = 0;
        public static final int RIGHT_JOYSTICK_CHANNEL = 1;
        public static final int LEFT_BUTTON_BOX_CHANNEL = 2;
        public static final int RIGHT_BUTTON_BOX_CHANNEL = 3;
    }

    public static final double MAX_BATTERY_VOLTAGE = 12.0;
    public static final double LOOP_TIME_S = .2;

    public static final class DrivetrainConstants {

        public static final int LEFT_LEADER_CHANNEL = 1;
        public static final int LEFT_FOLLOWER_CHANNEL = 2;
        public static final int RIGHT_LEADER_CHANNEL = 3;
        public static final int RIGHT_FOLLOWER_CHANNEL = 4;

    }
}
