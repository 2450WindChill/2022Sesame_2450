package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
    public final CANSparkMax ExtendClimbArm = new CANSparkMax(5, MotorType.kBrushed);
    public final CANSparkMax RetractClimbArm = new CANSparkMax(6, MotorType.kBrushed);
    public final CANSparkMax AngleAdjustmentArm = new CANSparkMax(7, MotorType.kBrushed);
    public final Encoder encoder1 = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
    public final DigitalInput limitSwitch1 = new DigitalInput(2);
    public ClimberSubsystem() {

    }
    

    public void ManualExtendsInputs(XboxController xbox) {
        // Unfinished need 'if' statement to check if value is negative or positive to
        // use either ExtendClimbArm motor or RetractClimbArm motor
        ExtendClimbArm.set(xbox.getRightX());
    }

}
