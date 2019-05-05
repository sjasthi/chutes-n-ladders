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
3. Select `build.gradle` from the check out location and click `OK`
4. In IntelliJ Settings, enable Annotation Processing for Lombok to work   

## Design Philosophy
The backend is designed with an intention to support the below behavior on UI
1. UI shows option to either start new game or resume an existing one
![Home Screen](res/screen1.jpg) 
2. UI can get the details of the game (like in which order will the players play, player positions, etc) from `game` instance
3. To play the game UI calls `nextMove()` on the `game` instance
4. The `game` executes the move and returns the result of the move to UI process:
   - Affected player and his updated position
   - Whether he's reached the finish point or not
   - If reached, what's his rank
   - Any ladders or chutes encountered during the move
5. UI can use this info to update the UI and to decide whether to end the game or continue


## TODO
- [ ] Add more design details (structure of code, main interfaces, etc) to README
- [ ] Write test cases
- [ ] Enhance
