import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private final PWMTalonSRX m_leftMotor1 = new PWMTalonSRX(Constants.kDriveLeftMotor1);
    private final PWMTalonSRX m_leftMotor2 = new PWMTalonSRX(Constants.kDriveLeftMotor2);

    private final PWMTalonSRX m_rightMotor1 = new PWMTalonSRX(Constants.kDriveRightMotor1);
    private final PWMTalonSRX m_rightMotor2 = new PWMTalonSRX(Constants.kDriveRightMotor2);

    private final MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
    private final MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);

    public DriveSubsystem() {
        m_leftGroup.setInverted(Constants.kDriveLeftInverted); 
        m_rightGroup.setInverted(Constants.kDriveRightInverted); 
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        m_drive.stopMotor();
    }
}