package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  // Defining motors and putting the right motors in a motor control group
  public final WPI_VictorSPX m_rightMotor = new WPI_VictorSPX(1);
  public final WPI_VictorSPX m_rightMotor2 = new WPI_VictorSPX(2);
  public final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(m_rightMotor, m_rightMotor2);

  // Defining motors and putting the left motors in a motor control group
  public final WPI_VictorSPX m_leftMotor = new WPI_VictorSPX(3);
  public final WPI_VictorSPX m_leftMotor2 = new WPI_VictorSPX(4);
  public final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(m_leftMotor, m_leftMotor2);

  // Takes motor control groups and puts them in a differential drive
  // Putting motors into different motor groups
  // Confused about this code
  public final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public DriveTrainSubsystem() {
    double rate = 0.4; //drive rate

    // Inital acceleration of the robot (adjuste)
    m_rightMotor.configOpenloopRamp(rate);
    m_rightMotor2.configOpenloopRamp(rate);
    m_leftMotor.configOpenloopRamp(rate);
    m_leftMotor2.configOpenloopRamp(rate);

    // Inverting the motors (as needed)
  
    m_rightMotor.setInverted(false);
    m_rightMotor2.setInverted(false);
    m_leftMotor.setInverted(false);
    m_leftMotor2.setInverted(false);
  }

  public void takeXboxInputs(XboxController xbox) {
    m_robotDrive.curvatureDrive((xbox.getLeftTriggerAxis() + -xbox.getRightTriggerAxis()), xbox.getLeftX() * .75 //turn rate
    , xbox.getAButton());
    //m_robotDrive.curvatureDrive(0, 0, xbox.getAButton());
  }
}
