/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.*;
import org.firstinspires.ftc.teamcode.Autonomous.ChampBot;


@TeleOp(name="TankDriveBernardo", group="ChampBot")
public class TankDriveBernardo extends OpMode {
    ChampBot robot = new ChampBot();
    public ElapsedTime runtime = new ElapsedTime();
    boolean slowcheck = false;


    @Override
    public void init() {
        /*
         * Use the hardwareMap to get the dc motors and servos by name. Note
         * that the names of the devices must match the names used when you
         * configured your robot and created the configuration file.
         */
        robot.init(hardwareMap);
        robot.DriveFrontLeft.setPower(0);
        robot.DriveFrontRight.setPower(0);
        robot.DriveBackLeft.setPower(0);
        robot.DriveBackRight.setPower(0);
    }
    public void RightStrafe() {
        robot.DriveFrontLeft.setPower(1);
        robot.DriveFrontRight.setPower(1);
        robot.DriveBackLeft.setPower(-1);
        robot.DriveBackRight.setPower(1);
    }
    public void LeftStrafe() {
        robot.DriveFrontLeft.setPower(-1);
        robot.DriveFrontRight.setPower(-1);
        robot.DriveBackLeft.setPower(1);
        robot.DriveBackRight.setPower(-1);
    }
    public void MotorsStopped() {
        robot.DriveFrontLeft.setPower(0);
        robot.DriveFrontRight.setPower(0);
        robot.DriveBackLeft.setPower(0);
        robot.DriveBackRight.setPower(0);
    }

    @Override
    public void loop() {
        // tank drive: each stick controls one side of the robot
        // dpad for strafing left/right
        float DLY = gamepad1.left_stick_y;
        float DRY = gamepad1.right_stick_y;
        float DLSX = gamepad1.left_stick_x;
        float DLX = Math.abs(DLSX);
        float DRSX = gamepad1.left_stick_x;
        float DRX = Math.abs(DRSX);
        boolean WheelToggle = false;
        float rightPower = DLY/DLX;
        float leftPower = DRY/DRX;
        /*
        telemetry.addData("left x-stick: ", gamepad1.left_stick_x);
        telemetry.addData("right x-stick: ", gamepad1.right_stick_x);
        telemetry.addData("left y-stick: ", gamepad1.left_stick_y);
        telemetry.addData("right y-stick: ", gamepad1.right_stick_y);
        telemetry.addData("right tangent: ", rightPower);
        telemetry.addData("left tangent: ", leftPower);
*/
        if (DLSX == -1 && DLY == 0 && DRSX == -1 && DRY == 0) {
            // to right strafe, right motors towards each other, left motors away from each other
            RightStrafe();
        } else if (DLSX == 1 && DLY == 0 && DRSX == 1 && DRY == 0) {
            // opposite of right strafe
            LeftStrafe();
        }
        else
            robot.setDriveMotors(rightPower, -leftPower, rightPower, leftPower);
        /*if (gamepad1.y) {
            robot.WheelMotor.setPower(1);
            //robot.IntakeMotor.setPower(1);
        } else {
            robot.WheelMotor.setPower(0);
            robot.ArmMotor.setPower(0);
            //robot.IntakeMotor.setPower(0);
        }
        if (gamepad1.left_bumper) {
            robot.WheelMotor.setPower(-1);
            //robot.IntakeMotor.setPower(-1);
        } else {
            robot.WheelMotor.setPower(0);
            //robot.IntakeMotor.setPower(0);
        }
        if (gamepad1.dpad_up) {
            robot.ArmMotor.setPower(1);
        } else {
            robot.WheelMotor.setPower(0);
            robot.ArmMotor.setPower(0);
        }
        if (gamepad1.dpad_down) {
            robot.ArmMotor.setPower(-1);
        } else {
            robot.WheelMotor.setPower(0);
            robot.ArmMotor.setPower(0);
        }
        if (gamepad1.b) {
            robot.WheelMotor.setPower(0);
            robot.ArmMotor.setPower(0);
        } else {
            robot.WheelMotor.setPower(0);
            robot.ArmMotor.setPower(0);
        }
            //if (gamepad1.right_bumper) {
            //robot.LauncherMotor.setPower(-1);
            //}
            //else {
            // robot.LauncherMotor.setPower(0);
            //}


            //if (gamepad1.left_bumper) {
                //DriveLeftPower = DriveLeftPower / 2;
                //DriveRightPower = DriveRightPower / 2;
            //}

            robot.setDriveMotors(DriveLeftPower, DriveRightPower, DriveLeftPower, DriveRightPower);
        }
    }
*/
    }
}