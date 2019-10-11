#include <AFMotor.h>

  AF_DCMotor  motorFR(1);
  AF_DCMotor  motorBR(4);
  AF_DCMotor  motorFL(2);
  AF_DCMotor  motorBL(3);
  

void setup() {
  
  Serial.begin(9600);
  
  // MOTOR VELOCITY
  motorFR.setSpeed(255);
  motorBR.setSpeed(255);
  motorFL.setSpeed(255);
  motorBL.setSpeed(255);
  

  // starts with no movement
  motorFR.run(RELEASE);
  motorBR.run(RELEASE);
  motorFL.run(RELEASE);
  motorBL.run(RELEASE);

  
}

void loop() {

  delay(3000);
  
  moveForward();
  delay(1000);
  halt();
  delay(500);

  moveRight();
  delay(1600);
  halt();
  delay(500);

  moveForward();
  delay(800);
  halt();
  delay(500);
  
  //moveRight();
  motorFL.run(BACKWARD);
  motorBL.run(BACKWARD);
  delay(3500);
  halt();
  delay(500);
  
  moveForward();
  delay(1000);
  halt();
  delay(500);
   
}
  void moveForward() {
    motorFR.run(FORWARD);
    motorBR.run(FORWARD);
    motorFL.run(FORWARD);
    motorBL.run(FORWARD);
    
  }

  void moveBackward() {
    motorFR.run(BACKWARD);
    motorBR.run(BACKWARD);
    motorFL.run(BACKWARD);
    motorBL.run(BACKWARD);
  }

  void moveRight() {
    motorFR.run(RELEASE);
    motorBR.run(RELEASE);
    motorFL.run(FORWARD);
    motorBL.run(FORWARD);
  }

  void moveLeft() {
    motorFR.run(FORWARD);
    motorBR.run(FORWARD);
    motorFL.run(RELEASE);
    motorBL.run(RELEASE);
  }

  void halt() {
    motorFR.run(RELEASE);
    motorFL.run(RELEASE);
    motorBR.run(RELEASE);
    motorBL.run(RELEASE);
  }
