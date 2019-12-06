lastDate(0).
lastTime(0).

!start.


+!start : true <- .print("hello world.").

+currentDate(Date)[source(Sensor)] : lastDate(Last) & Last-Date>0
   <- -+lastDate(Date); 
      .print("Current date updated to ", Date, " by the sensor ", Sensor).
   
+currentTime(Time)[source(Sensor)] : lastTime(Last) & Time-Last > 2
   <- -+lastTime(Time);
      .print("Current time updated to ", Time, " by the sensor ", Sensor).

