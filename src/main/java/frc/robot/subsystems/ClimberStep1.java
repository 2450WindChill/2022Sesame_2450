package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberStep1 extends SubsystemBase{
    public final CANSparkMax ClimberStep1Motor = new CANSparkMax(5, MotorType.kBrushed);
}
