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

    public static final class CollectorConstants {

        public static final int COLLECTOR_MOTOR_CHANNEL = 1;
        public static final int COLLECTOR_SOLENOID_PORT_IN = 2;
        public static final int COLLECTOR_SOLENOID_PORT_OUT = 3;
    }

    public static final double MAX_BATTERY_VOLTAGE = 12.0;
    public static final double LOOP_TIME_S = .2;

    public static final class DrivetrainConstants {

        public static final int LEFT_LEADER_CHANNEL = 9;
        public static final int LEFT_FOLLOWER_CHANNEL = 10;
        public static final int RIGHT_LEADER_CHANNEL = 13;
        public static final int RIGHT_FOLLOWER_CHANNEL = 12;

        public static final double TRACKWIDTH_METERS = 0.781987; // horizontal distance between wheels

        public static final double COUNTS_PER_MOTOR_REVOLUTION = 2048;
        public static final double WHEEL_DIAMETER_METERS = 0.1524;
        public static final double WHEEL_REVOLUTIONS_PER_MOTOR_REVOLUTIONS =
                (18.0 / 52.0) * (10.0 / 42.0);
        public static final double METERS_PER_COUNT =
                (1 / COUNTS_PER_MOTOR_REVOLUTION)
                        * // MOTOR ROTATIONS per count
                        WHEEL_REVOLUTIONS_PER_MOTOR_REVOLUTIONS
                        * (WHEEL_DIAMETER_METERS * Math.PI);

        public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
                new DifferentialDriveKinematics(TRACKWIDTH_METERS);

        public static final int MAX_SPEED_METERS_PER_SECOND = 0;
        public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 2;
        public static final int MAX_VOLTAGE = 11;

        public static final double S_VOLTS = 0; // TODO
        public static final double V_VOLT_SECONDS_PER_METER = 0; // TODO
        public static final double A_VOLT_SECONDS_SQUARED_PER_METER = 0; // TODO
        public static final SimpleMotorFeedforward DRIVE_FEED_FORWARD =
                new SimpleMotorFeedforward(
                        DrivetrainConstants.S_VOLTS,
                        DrivetrainConstants.V_VOLT_SECONDS_PER_METER,
                        DrivetrainConstants.A_VOLT_SECONDS_SQUARED_PER_METER);

        public static final DifferentialDriveVoltageConstraint AUTO_VOLTAGE_CONSTRAINT =
                new DifferentialDriveVoltageConstraint(
                        DrivetrainConstants.DRIVE_FEED_FORWARD,
                        DrivetrainConstants.DRIVE_KINEMATICS,
                        DrivetrainConstants.MAX_VOLTAGE);

        public static final double RAMSETE_B = 2; // TODO
        public static final double RAMSETE_ZETA = .9; // TODO

        public static final double P = 0; // TODO
        public static final double I = 0;
        public static final double D = 0;
        public static final double F = 0;

        public static final int SLOT_ID = 0;
        public static final int PID_LOOPTYPE = 0;
        public static final int TIMEOUT_MS = 20;
    }

    public static final class ShooterConstants {
        public static final int LEADER_CHANNEL = 4;
        public static final int FOLLOWER_CHANNEL = 7;
        public static final int BALLPATH_CHANNEL = 3;

        public static final double MOTOR_TO_WHEEL = 0.5;
        public static final int COUNTS_PER_REVOLUTION = 12; // TODO
        public static final int RPM_THRESHOLD = 200; // TODO
        public static final double WHEEL_DIAMETER = 5;

        public static final double P = 25;
        public static final double I = 0;
        public static final double D = 0;
        public static final double F = 3.3;

        public static final int SLOT_ID = 0;
        public static final int PID_LOOPTYPE = 0;
        public static final int TIMEOUT_MS = 20;

        public static final int AUTO_LINE_SHOT = 4000;
        public static final int TRENCH_SHOT = 4200;
        public static final int UP_CLOSE_SHOT = 2650;
    }

    public static final class HoodConstants {
        public static final int HOOD_UP_PORT = 4;
        public static final int HOOD_DOWN_PORT = 6;
        public static final int SERVO_PORT = 2;
    }

    public static final class ChaosRevolverConstants {
        public static final int REVOLVER_MOTOR_CHANNEL = 2;
    }

    public static final class ClimberConstants {
        public static final int SLIDER_MOTOR_CHANNEL = 8;
        public static final int TRAVERSAL_MOTOR_CHANNEL = 6;
        public static final int WINCH_MOTOR_CHANNEL = 11;
        public static final int LIFTING_UP_PORT = 0;
        public static final int LIFTING_DOWN_PORT = 1;
        public static final int PIN_PORT = 5;
        public static final int COLOR_MOTOR_CHANNEL = 5;

        public static final int TRIGGER_PIN_VALUE = 3850;
        public static final int CLIMBER_SWITCH_PORT = 1;
        public static final int SLIDER_SWITCH_PORT = 0;
        public static final int LIFTING_POT_PORT = 0;
    }

    public static final class LEDConstants {
        public static final int BLINKIN_PARK_CHANNEL = 1;
    }
}
