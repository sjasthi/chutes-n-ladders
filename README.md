# Chutes And Ladders
Back-end code in Java for Chutes and Ladders game

## Simulator
The project also contains a simulation for the game.

You can run the simulation in following ways:

#### Using gradle wrapper
From the root directory
1. Run command `./gradlew build` to build
2. Run command `./gradlew run` to run the simulation

#### Directly running the main method
1. Run the main method in `com.rezilience.runner.SimulateGame` (assuming you have built the code already) 

### Simulator O/p
Each line in o/p indicates a move

`1: Eric: 0 --> 2` => (sr. no): (player name): (start) --> (end)  
That is, Eric was at 0 and moved to 2

`7: Eric: 6 --> 9 --LADDER--> 31`  
Eric was at 6, moved to 9 (sninner value was 3), found a ladder on 9, taking him to 31 

`61: Paul: 99 -x-> 105 --> 99`  
Paul was at 99, scored a 6, but since 105 is more than 100 (finish point), he's still at 99

`64: Eric: 97 --> 100`  
`The winner is Eric!`
Voila! Eric reached 100 and won the game.

## IntelliJ Setup
1. Check out in a local directory
2. In IntelliJ, select `File -> New -> Project from Existing Sources...`
3. Select `build.gradle` from the check out location
4. In IntelliJ Settings, enable Annotation Processing for Lombok to work   