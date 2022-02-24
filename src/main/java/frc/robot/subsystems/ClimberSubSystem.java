package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubSystem extends SubsystemBase{
    public final CANSparkMax ClimberStep1Motor = new CANSparkMax(5, MotorType.kBrushed);
}
