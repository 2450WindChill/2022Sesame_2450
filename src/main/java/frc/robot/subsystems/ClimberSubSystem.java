package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.sound.sampled.SourceDataLine;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;

public class ClimberSubsystem extends SubsystemBase {
    double neoSpeedVertical = 0.35;
    double neoSpeedAngle = 0.35;

    // public final DCMotor VerticalMotor = new DCMotor(2, 0, 0, 0,
    // neoSpeedVertical, 1);
    // public final DCMotor AngleAdjustmentMotor = new DCMotor(0, 0, 0, 0,
    // neoSpeedAngle, 0);

    public final CANSparkMax VerticalMotor = new CANSparkMax(5, MotorType.kBrushless);
    public final CANSparkMax AngleAdjustmentMotor = new CANSparkMax(6, MotorType.kBrushless);

    public final RelativeEncoder verticalEncoder = VerticalMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    public final RelativeEncoder angleEncoder = AngleAdjustmentMotor.getEncoder();

    // public final Encoder verticalEncoder = new Encoder(8, 9, false,
    // Encoder.EncodingType.k1X);
    // public final Encoder angleEncoder = new Encoder(2, 3, false,
    // Encoder.EncodingType.k1X);

    // public final DigitalInput maxRetractSwitch = new DigitalInput(4);
    // public final DigitalInput maxAngleUpSwitch = new DigitalInput(7);
    // public final DigitalInput maxAngleDownSwitch = new DigitalInput(5);

    PIDController pid = new PIDController(0.00000125, 0, 0);

    public ClimberSubsystem() {
        VerticalMotor.setIdleMode(IdleMode.kBrake);
        AngleAdjustmentMotor.setIdleMode(IdleMode.kBrake);
    }

    public void ManualInputs(XboxController xbox) {
        // System.out.println("Value of the left joystick " + xbox.getLeftY());
        // System.out.println("Value of the right joystick " + xbox.getRightY());
        // Joystick drift protection
        if ((xbox.getRightX() < .15) && (xbox.getRightX() > -0.15)) {
            AngleAdjustmentMotor.set(0);
            // neoSpeedAngle = 0;
            // AngleAdjustmentMotor.set(0);

            // Protection for angling up to far
            // } else if ((xbox.getRightY() > 0) && (maxAngleUpSwitch.get() == true)) {
            // AngleAdjustmentMotor.set(0);
        }
        // Protection for angling down to far
        // else if ((xbox.getRightY()) < 0 && (maxAngleDownSwitch.get() == true)) {
        // AngleAdjustmentMotor.set(0);

        // Otherwise move motors normally
        else {
            AngleAdjustmentMotor.set(-xbox.getRightX());
        }

        // Joystick drift protection
        if ((xbox.getLeftY() < .15) && (xbox.getLeftY() > -0.15)) {
            VerticalMotor.set(0);
        // Otherwise move the motors normally
        } else {
            VerticalMotor.set(-xbox.getLeftY());

        }
        // System.out.println("Encoder value: " + verticalEncoder.getPosition());
    }

    /*
     * ARM LIMITS
     */

    public void VerticalExtentionPID(double verticalExtensionGoal) {
        // neoSpeedVertical = pid.calculate(verticalEncoder.getPosition(),
        // verticalExtensionGoal);
        VerticalMotor.set(pid.calculate(verticalEncoder.getPosition(),
                verticalExtensionGoal));
    }

    public void VerticalRetractionPID(double verticalRetractionGoal) {
        // neoSpeedVertical = pid.calculate(verticalEncoder.getPosition(),
        // verticalRetractionGoal);
        VerticalMotor.set(pid.calculate(verticalEncoder.getPosition(),
                verticalRetractionGoal));
    }

    // Angular PID
    public void AngleBackPID(double angleBackGoal) {
        // neoSpeedAngle = pid.calculate(verticalEncoder.getPosition(), angleBackGoal);
        AngleAdjustmentMotor.set(pid.calculate(angleEncoder.getPosition(),
                angleBackGoal));
    }

    public void AngleForwardPID(double angleForwardGoal) {
        // neoSpeedVertical = pid.calculate(verticalEncoder.getPosition(),
        // angleForwardGoal);
        AngleAdjustmentMotor.set(pid.calculate(angleEncoder.getPosition(),
                angleForwardGoal));
    }

    public void setVerticalSpeed(int i) {
    }

    // public void setVerticalSpeed(double newSpeedVertical) {
    // neoSpeedVertical = newSpeedVertical;
    // }

    // public void setAngleSpeed(double newSpeedAngle) {
    // neoSpeedAngle = newSpeedAngle;
    // }
}