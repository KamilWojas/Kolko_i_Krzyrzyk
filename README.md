# Tic Tac Toe

Projetk is performed in classes in the basics of programming. Description of the action: Draws whether it starts X or O

Can be inserted into empty fields by entering an index (1-9)

There is validation whether someone gives a good index or int at all and not any string

After each move, the view in the console refreshes

And asks the next player to provide an index

The game lasts 9 moves each time, because there is no mechanism to check if someone won, I have prepared a function that will break the game loop when it returns true, for now I have given that it always returns false - that's why the game always has 9 moves. There is also a mechanical test in this function. If index >9 is given, it will not work properly.
