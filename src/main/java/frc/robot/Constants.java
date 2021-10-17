package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public final class Constants {

    /**
     * Constants for the Inputs, like Attack 3s and Xbox Controllers
     */
    public static final class InputConstants {

        public enum INPUT_METHOD {
            CONTROLLER,
            STICKS,
            KINECT
        }

        // USB Ids
        public static final int LEFT_JOYSTICK_CHANNEL = 0;
        public static final int RIGHT_JOYSTICK_CHANNEL = 1;
        public static final int DRIVER_XBOX_CHANNEL = 2;
        public static final int OPERATOR_XBOX_CHANNEL = 3;
    }

    /**
     * Constants for the drivetrain
     */
    public static final class DrivetrainConstants {

        public enum DRIVE_STYLE {
            ARCADE,
            TANK,
            CURVATURE
        }

        // CAN Ids
        public static final int LEFT_LEADER_CHANNEL = 1;
        public static final int LEFT_FOLLOWER_CHANNEL = 2;
        public static final int RIGHT_LEADER_CHANNEL = 3;
        public static final int RIGHT_FOLLOWER_CHANNEL = 4;

        // PID Constants (Not Auto Constants)
        public static final int SLOT_ID = 0;
        public static final int PID_LOOPTYPE = 0;
        public static final int TIMEOUT_MS = 20;
        public static final double P = 0;
        public static final double I = 0;
        public static final double D = 0;
        public static final double F = 0;


    }
}
