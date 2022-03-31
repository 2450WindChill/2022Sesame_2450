package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;

public class ClimberSubsystem extends SubsystemBase {
    public final CANSparkMax VerticalMotor = new CANSparkMax(5, MotorType.kBrushed);
    // public final CANSparkMax RightVerticalMotor = new CANSparkMax(6, MotorType.kBrushed);
    public final CANSparkMax AngleAdjustmentMotor = new CANSparkMax(7, MotorType.kBrushed);
    // public final MotorControllerGroup VerticalMotors = new MotorControllerGroup(LeftVerticalMotor, RightVerticalMotor);

    public final Encoder verticalEncoder = new Encoder(8, 9, false, Encoder.EncodingType.k1X);
    public final Encoder angleEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k1X);

    // public AnalogPotentiometer verticalPot = new AnalogPotentiometer(0);
    // public AnalogPotentiometer anglePot = new AnalogPotentiometer(1);


    public final DigitalInput maxRetractSwitch = new DigitalInput(7);
    public final DigitalInput maxAngleUpSwitch = new DigitalInput(4);
    public final DigitalInput maxAngleDownSwitch = new DigitalInput(5);

    PIDController pid = new PIDController(0.00000125, 0, 0);

    public ClimberSubsystem() {
        //BRAKE MODE BREAKS MOTOR, DO NOT TURN ON

        VerticalMotor.setIdleMode(IdleMode.kBrake);
        // RightVerticalMotor.setIdleMode(IdleMode.kBrake);
        AngleAdjustmentMotor.setIdleMode(IdleMode.kBrake);
    }

    public void ManualInputs(XboxController xbox) {
        System.out.println("Value of the left joystick  " + xbox.getLeftY());
        System.out.println("Value of the right joystick " + xbox.getRightY());
        // Joystick drift protection
        if ((xbox.getRightX() < .15) && (xbox.getRightX() > -0.15)) {
           AngleAdjustmentMotor.set(0);

            // Protection for angling up to far
        // } else if ((xbox.getRightY() > 0) && (maxAngleUpSwitch.get() == true)) {
        //     AngleAdjustmentMotor.set(0);
        }
            // Protection for angling down to far
        //else if ((xbox.getRightY()) < 0 && (maxAngleDownSwitch.get() == true)) {
        //     AngleAdjustmentMotor.set(0);

            // Otherwise move motors normally
        else {
            AngleAdjustmentMotor.set(-xbox.getRightX());
        }


        // Joystick drift protection
        if ((xbox.getLeftY() < .15) && (xbox.getLeftY() > -0.15)) {
            VerticalMotor.set(0);

        // Protection for retracting to far
        // Reading negative when going up
        } else if ((xbox.getLeftY() > 0) && (maxRetractSwitch.get() == true)) {
            VerticalMotor.set(0);
            System.out.println("Should be stopping: " + xbox.getLeftY());

        // Otherwise move the motors normally
        } else {
            VerticalMotor.set(xbox.getLeftY());
            //System.out.println("Value of the right joystick: " + xbox.getRightX());
        }
    }

    /*
     * ARM LIMITS
     */

    public void VerticalExtentionPID(double verticalExtensionGoal) {
        VerticalMotor.set(pid.calculate(verticalEncoder.getDistance(), verticalExtensionGoal));
    }

    public void VerticalRetractionPID(double verticalRetractionGoal) {
        VerticalMotor.set(pid.calculate(verticalEncoder.getDistance(), verticalRetractionGoal));
    }

    // Angular PID
    public void AngleBackPID(double angleBackGoal) {
        AngleAdjustmentMotor.set(pid.calculate(angleEncoder.getDistance(), angleBackGoal));
    }

    public void AngleForwardPID(double angleForwardGoal) {
        AngleAdjustmentMotor.set(pid.calculate(angleEncoder.getDistance(), angleForwardGoal));
    }
}