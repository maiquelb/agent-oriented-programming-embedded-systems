#include <NewPing.h>
#include <AFMotor.h>


#define TRIGGER_PIN A5
#define ECHO_PIN A0
#define MAX_DISTANCE 200

NewPing sonar(TRIGGER_PIN, ECHO_PIN, MAX_DISTANCE);

  AF_DCMotor  motorFR(1);
  AF_DCMotor  motorBR(4);
  AF_DCMotor  motorFL(2);
  AF_DCMotor  motorBL(3);
  

void setup() {
  
  Serial.begin(115200);
  
  // VELOCIDADE DOS MOTORES
  motorFR.setSpeed(255);
  motorBR.setSpeed(255);
  motorFL.setSpeed(255);
  motorBL.setSpeed(255);
  

  // INICIAM PARADOS
  motorFR.run(RELEASE);
  motorBR.run(RELEASE);
  motorFL.run(RELEASE);
  motorBL.run(RELEASE);

  
}

void loop() {

  delay(500);
  while(sonar.ping_cm() > 10){
    
   /* Serial.print("Ping: ");
    Serial.print(sonar.ping_cm());
    Serial.println("cm");
   */
    
    moveForward();
  }
  
  halt();
  delay(2000);
   
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
