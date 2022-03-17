package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;

public class ClimberSubsystem extends SubsystemBase {
    public final CANSparkMax LeftVerticalMotor = new CANSparkMax(5, MotorType.kBrushed);
    public final CANSparkMax RightVerticalMotor = new CANSparkMax(6, MotorType.kBrushed);
    public final CANSparkMax AngleAdjustmentMotor = new CANSparkMax(7, MotorType.kBrushed);
    public final MotorControllerGroup VerticalMotors = new MotorControllerGroup(LeftVerticalMotor, RightVerticalMotor);

    public final Encoder verticalEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
    public final Encoder angleEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k1X);

    public AnalogPotentiometer verticalPot = new AnalogPotentiometer(0);
    public AnalogPotentiometer anglePot = new AnalogPotentiometer(1);
    
    PIDController pid = new PIDController(0, 0, 0);

    // lernie = left ernie and rernie = right ernie
    // public final DigitalInput lernieDown = new DigitalInput(3);
    // public final DigitalInput lernieUp = new DigitalInput(2);
    // public final DigitalInput lernieRight = new DigitalInput(4);
    // public final DigitalInput lernieLeft = new DigitalInput(5);
    // public final DigitalInput rernieUp = new DigitalInput(6);
    // public final DigitalInput rernieDown = new DigitalInput(7);
    //public final DigitalInput rernieRight = new DigitalInput(8);
    // public final DigitalInput rernieLeft = new DigitalInput(9);
    public State state = State.VERTICAL_ADJUSTER;
    public boolean doWeNeedToStopRumble = false;
    public double maxExtensionPot = 734;
    
 
    // Enum that defines the differnt possible states
    public enum State {
        ANGLE_ADJUSTER,
        VERTICAL_ADJUSTER,
    }

    public ClimberSubsystem() {

    }

    public void ManualInputs(XboxController xbox) {
        // If the controller is still rumbleing, then stop the rumbleing
        if (doWeNeedToStopRumble == true) {
            doWeNeedToStopRumble = false;
            xbox.setRumble(RumbleType.kLeftRumble, 0);
        }



    /*
    D-PAD
    */


        //System.out.println("The value of the POV is " + xbox.getPOV() + " degrees");

        // INFO ABOUT POV AND D-PAD:
        // The up and down buttons on the d-pad are the vertical adjusters
        // The left and right button on the d-pad are the angle adjusters
        // The POV of the xbox is the d-pads buttons which each correlate to degrees 90, 180, 270, 360
        // If the pov of the xbox is a certain degree (button), then set the state to its corrsponding states
        
        // If right or left button on d-pad are pressed and the state is vertical adjuster, then set the state to angle adjuster
        if ((xbox.getPOV() == Constants.pov_right) || (xbox.getPOV() == Constants.pov_left)) {
            state = State.ANGLE_ADJUSTER;
            SmartDashboard.putString("Current State", "ANGLE_ADJUSTER");
            // Vibrate the controller when you switch into this state
            xbox.setRumble(RumbleType.kLeftRumble, 1);

            // Turn rumble off
            doWeNeedToStopRumble = true;

        // Otherwise if up or down button on d-pad are pressedand the state is angle adjuster, then set the state to vertical adjuster
        } else if ((xbox.getPOV() == Constants.pov_up) || (xbox.getPOV() == Constants.pov_down)) {
            state = State.VERTICAL_ADJUSTER;
            SmartDashboard.putString("Current State", "VERTICAL_ADJUSTER");
            // Vibrate the controller when you switch into this state
            xbox.setRumble(RumbleType.kLeftRumble, 1);
            doWeNeedToStopRumble = true;

        // If not up, down, left, or right, then use the previously set state
        } else {

        }

        if (state == State.ANGLE_ADJUSTER) {
            if (xbox.getRightY() < .1 && xbox.getRightY() > -0.1){
                // Joystick drift protection
                AngleAdjustmentMotor.set(0);
            } else {
                AngleAdjustmentMotor.set(xbox.getRightY() / 2);
            }
            // Shutting off the other motors
            VerticalMotors.set(0);
        }

        else if (state == State.VERTICAL_ADJUSTER) {
            //xbox.setRumble(RumbleType.kRightRumble, 1);
            if (xbox.getRightY() < .1 && xbox.getRightY() > -0.1){
                // Joystick drift protection
                VerticalMotors.set(0);
            } else {
                VerticalMotors.set(xbox.getRightY() / 2);
            }
            // Shutting off the other motor
            AngleAdjustmentMotor.set(0);
        }
    }
    



    
    /*
    ARM LIMITS
    */

    public void VerticalStringPotExtentionLimit(AnalogPotentiometer verticalPot){
        // This is max for vertical
        if (verticalPot.get() * 1000000 < 800) { // Probably not 800
            // Insert PID for VerticalMotors
            VerticalMotors.set(pid.calculate(verticalPot.get() * 1000000, maxExtensionPot));
        } 
    }

    public void VerticalStringPotRetractionLimit(AnalogPotentiometer verticalPot){
        // This is minimum for vertical
        if (verticalPot.get() * 1000000 > 900) { // Probably not 900
            // Insert PID for VerticalMotors
            VerticalMotors.set(pid.calculate(verticalPot.get() * 1000000, maxExtensionPot));
        } 
    }



    // Angular Limits
    public void AngleStringPotForwardLimit(AnalogPotentiometer anglePot){
        // This is for max angle
        if (anglePot.get() * 1000000 < 800) { // Probably not 800
            // Insert PID for AngleAdjustmentMotors
            VerticalMotors.set(pid.calculate(anglePot.get() * 1000000, maxExtensionPot));
        }
    } 

    public void AngleStringPotBackwardLimit(AnalogPotentiometer anglePot){
        // This is for backward angle
        if (anglePot.get() * 1000000 > 900) {
            // Insert PID for AngleAdjustmentMotors
            VerticalMotors.set(pid.calculate(anglePot.get() * 1000000, maxExtensionPot));
        } 
    }
}