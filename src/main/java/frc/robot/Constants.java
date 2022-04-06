package frc.robot;

public final class Constants {
    // Auto Phase
    public static double autoDriveSpeedBackward = -0.6;
    public static double autoDriveSpeedForward = 0.4;
    public static long autoDriveTimeBackward = 750;
    public static long autoDriveTimeForward = 2000;

    // SetPointCommand
    public static double correctionSpeed = 0.2;

    // PID
    public static double PIDExtendTolerance = 95000;
    public static double PIDRetractTolerance = 5000;

    // States
    public static int pov_right = 90;
    public static int pov_left = 270;
    public static int pov_up = 0;
    public static int pov_down = 180;

}