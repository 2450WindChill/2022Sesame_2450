package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    public final WPI_TalonSRX topLaunchMotor = new WPI_TalonSRX(5);
    public final WPI_TalonSRX bottomLaunchMotor = new WPI_TalonSRX(6);
    
}
