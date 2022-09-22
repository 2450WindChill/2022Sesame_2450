package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubSystem extends SubsystemBase {
    public final CANSparkMax ExtendClimbArm = new CANSparkMax(5, MotorType.kBrushed);
    public final CANSparkMax RetractClimbArm = new CANSparkMax(6, MotorType.kBrushed);
    public final CANSparkMax AngleAdjustmentArm = new CANSparkMax(7, MotorType.kBrushed);

    public ClimberSubSystem() {

    }
}
