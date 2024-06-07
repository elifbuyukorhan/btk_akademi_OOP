#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <string>

using std::string;
using std::cout;
using std::endl;
using std::cin;

class Player 
{
protected:
    string name;
    string move;
    int score;

public:
    Player(string name, string move, int score) 
    {
        this->name = name;
        this->move = move;
        this->score = score;
    }

    virtual void manuel_strategy() = 0;
};

class ComputerPlayer 
{
protected:
    string name;
    int score;
public:
    ComputerPlayer(string name, int score)
    {
        this->name = name;
        this->score = score;
    }

    string getName() 
    {
        return this->name;
    }

    int getScore() 
    {
        return this->score;
    }

    void setScore() 
    {
        this->score++;
    }

    virtual void auto_strategy() = 0;
};

class HumanPlayer : public Player 
{
public:
    HumanPlayer(string name, string move, int score)
        : Player(name, move, score)
    {

    }

    string getName() 
    {
        return this->name;
    }
    int getScore()
    {
        return this->score;
    }
    void setName(string value)
    {
        this->name = value;
    }
    void setScore()
    {
        this->score++;
    }

    void manuel_strategy() override
    {
        cout << name << " played " << move;
    }
};

class RandomComputerPlayer : public ComputerPlayer 
{
private:
    string move;
public:
    string getMove()
    {
        return move;
    }

    RandomComputerPlayer(string name, int score)
        : ComputerPlayer(name, score)
    {
        this->move = "not defined";
    }

    void auto_strategy() override
    {
        std::srand(std::time(0));
        int random = std::rand() % 3;
        switch (random) {
            case 0:
                move = "scissors";
                cout << name << " played " << move << endl;
                break;
            case 1:
                move = "rock";
                cout << name << " played " << move << endl;
                break;
            case 2:
                move = "paper";
                cout << name << " played " << move << endl;
                break;
        }
    }
};

int main() 
{   
    std::vector<std::string> humanMoveList;
    std::vector<std::string> computerMoveList;
    string req;
    string move;
    int round = 0;
    HumanPlayer hp1 = HumanPlayer("Elif", move, 0);
    RandomComputerPlayer cp1 = RandomComputerPlayer("Random Computer", 0);

    while (1) 
    {
        cout << "Please make a move 'rock, paper or scissors': " << endl;
        cin >> move;

        if(!((move == "rock") || (move == "paper") || (move == "scissors"))) {
            cout << "Please enter a valid move!" << endl;
            cin >> move;
        }
    
        cp1.auto_strategy();

        if (cp1.getMove() == move) {
            cout << "There are no winners. The score has not change." << endl;

        } else if (cp1.getMove() == "rock") {

            if(move == "paper") {
                hp1.setScore();
                cout << hp1.getName() << " won." << endl;
            } else if (move == "scissors") {
                cp1.setScore();
                cout << cp1.getName() << " won." << endl;
            }

        } else if (cp1.getMove() == "paper") {

            if(move == "rock") {
                cp1.setScore();
                cout << cp1.getName() << " won." << endl;
            } else if (move == "scissors") {
                hp1.setScore();
                cout << hp1.getName() << " won." << endl;
            }

        } else if (cp1.getMove() == "scissors") {

            if(move == "paper") {
                cp1.setScore();
                cout << cp1.getName() << " won." << endl;
            } else if (move == "rock") {
                hp1.setScore();
                cout << hp1.getName() << " won." << endl;
            }

        }

        humanMoveList.push_back(move);
        computerMoveList.push_back(cp1.getMove());
        round++;

        cout << round <<". round has been completed. Do you want to continue the game? (yes or no)" << endl;
        cin >> req;

        if (req == "no") {
            cout << cp1.getName() << " has " << cp1.getScore() << " score and " << hp1.getName() << " has " << hp1.getScore() << " score." << endl;
            cout << "Move History of " << cp1.getName() << ": " << endl;
            for (const auto& item : computerMoveList) {
                std::cout << item << std::endl;
            }
            cout << "Move History of " << hp1.getName() << ": " << endl;
            for (const auto& item : humanMoveList) {
                std::cout << item << std::endl;
            }
            if (cp1.getScore() < hp1.getScore()) {
                cout << hp1.getName() << " won the game. Congratulations!" << endl;
                break;
            } else if (cp1.getScore() > hp1.getScore()) {
                cout << cp1.getName() << " won the game. A small misfortune happened!" << endl;
                break;
            } else {
                cout << "The game ended in a draw." << endl;
                break;
            }
        } else if (req == "yes") {
            continue;
        } else {
            cout << "Please enter a valid word!" << endl;
            cin >> req;
        }
    }

    return 0;
}
