# Snake-ladder-game
Snake and Ladder Game is a graphical board game developed using Java and Java Swing. The game allows two players to roll dice, move across the board, climb ladders, and avoid snakes. It demonstrates GUI design, event handling, random number generation, and object-oriented programming concepts without using any database.
# Snake and Ladder Game

A simple and interactive Snake and Ladder Game developed using Java Swing. The main goal of this game is to move a player's token from the starting position to the final position by rolling a dice while avoiding snakes and using ladders to move forward.

## Project Overview

The Snake and Ladder Game is a board-based game where two players take turns rolling a dice and moving their tokens across a numbered board from 1 to 100. Players can move forward according to the dice result. If a player lands on a snake, the token moves down to a lower position. If a player lands on a ladder, the token moves up to a higher position.

The main features of the game include:

* Rolling a dice
* Moving player tokens across the board
* Climbing ladders
* Sliding down snakes
* Switching turns between players
* Reaching the final position to win the game

## Technologies Used

* Java
* Java Swing
* Object-Oriented Programming (OOP)
* AWT and GUI Components
* Event Handling

## Features

* User-friendly graphical interface
* Numbered game board from 1 to 100
* Two-player gameplay
* Interactive dice rolling
* Visible player tokens
* Snake and ladder positions
* Automatic player movement
* Turn indicator
* Game status display
* Reset game option
* Winning condition

## Objective

The objective of the game is to reach position 100 before the other player by rolling the dice, moving across the board, using ladders to climb up, and avoiding snakes that move the player down.

## How to Play

1. Start the Snake and Ladder Game.
2. Player 1 rolls the dice by clicking the Roll Dice button.
3. The player's token moves forward according to the dice result.
4. If the player lands on a ladder, the token moves to a higher position.
5. If the player lands on a snake, the token moves to a lower position.
6. After the move is completed, the turn changes to the other player.
7. Players continue taking turns until one player reaches position 100.
8. The game displays a winning message when a player wins.
9. Use the Reset button to start a new game.

## Main Operations

**Dice Rolling**

Generates a random number from 1 to 6 to determine how many steps a player can move.

**Player Movement**

Moves the player's token forward on the board according to the dice result.

**Snake**

When a player lands on a snake's head, the token moves down to the position of the snake's tail.

**Ladder**

When a player lands at the bottom of a ladder, the token moves up to the top of the ladder.

**Turn Management**

Controls the turns of Player 1 and Player 2 so that they play alternately.

**Win Condition**

The game checks whether a player has reached position 100. If the winning condition is satisfied, the game displays a winning message.

**Reset Game**

Resets the player positions, dice result, move status, and other game information to start a new match.

## Project Structure

```text
SnakeAndLadderGame/
│
├── MainGame.java
├── Board.java
├── Dice.java
├── Player.java
├── GamePanel.java
└── README.md
```

*Note: The file structure above represents the main classes of the project. The actual repository may contain additional files.*

## Interface

The game interface contains:

* A numbered board from 1 to 100
* Snake and ladder graphics
* Player tokens
* Roll Dice button
* Reset button
* Dice result display
* Current player's turn indicator
* Game status message

## How to Run

1. Install the Java Development Kit (JDK).
2. Open the project in an IDE such as NetBeans.
3. Open the Java source files.
4. Make sure the required classes are included in the project.
5. Run the main game class, `MainGame.java`.
6. The Snake and Ladder Game window will appear.
7. Click the Roll Dice button to start playing.

## Learning Outcomes

Through this project, we learned:

* Java programming fundamentals
* Java Swing GUI development
* Object-Oriented Programming
* Classes and objects
* Event handling
* Conditional statements and loops
* Random number generation
* Array and board management
* HashMap for storing snake and ladder positions
* Game logic implementation
* GUI-based user interaction

## Limitations

* The game is designed for two players.
* The game does not use a database.
* Previous match results are not saved.
* The game does not include an online multiplayer mode.
* The game has a predefined board and snake and ladder positions.

## How to Download and Run the Project from GitHub

**Step 1: Open the GitHub Repository**

Open the project repository in your browser:

https://github.com/tanisharafa/Snake-ladder-game

**Step 2: Download the Project**

1. Open the GitHub repository.
2. Click the green **Code** button.
3. Select **Download ZIP**.
4. Wait for the ZIP file to download.
5. Extract the ZIP file to a folder on your computer.

**Step 3: Open the Project**

1. Open NetBeans or another Java IDE.
2. Create or open a Java project.
3. Add the downloaded `.java` files to the project.
4. Make sure all required classes are included.

**Step 4: Run the Game**

Open `MainGame.java` and run the program. The graphical Snake and Ladder Game window will appear, and you can start playing.

## Future Improvements

Future versions of the project could include:

* More board designs
* Sound effects
* Player name selection
* Score and match history
* Animated snake and ladder movements
* More customization options
* Improved graphics
* Online multiplayer mode
* Different game difficulty levels

## Developed By

Tanisha Rashid Rafa
