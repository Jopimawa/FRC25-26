package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.OuttakeSubsystem;

public class Outtake extends Command {

    private final OuttakeSubsystem m_outtake;
    private final double m_speed;

    public Outtake(OuttakeSubsystem outtake, double speed) {
        m_outtake = outtake;
        addRequirements(m_outtake);
    }

    @Override
    public void initialize() {
        m_outtake.setSpeed();
    }

    @Override
    public void end(boolean interrupted) {
        m_outtake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}