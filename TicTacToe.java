/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.*;
/**
 *
 * @author prana
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    private char[][] board = new char[3][3];
    private char currentPlayer;
    
    //constructor
    public TicTacToe()
    {
        int num = 1;
        for(int i=2; i>=0; i--)
            for(int j=0; j<3; j++)
            {
                board[i][j] =(char)(num+48);
                num++;
            }
    }
    
    public void setCurrentPlayer(char mark)
    {
        currentPlayer = mark;
    }
    
    public void printBoard()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                System.out.print(board[i][j]);
                if(j!=2)
                    System.out.print("|");
            }
            System.out.println();
            if(i!=2)
                System.out.println("-----");
        }
    }
    
    public boolean isBoardFull()
    {
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(Character.isDigit(board[i][j]))
                    return false;
        return true;
    }
    
    public boolean checkForWin()
    {
        if(checkRowsForWin())
            return true;
        else if(checkColumnsForWin())
            return true;
        else if(checkDiagForWin())
            return true;
        else
            return false;
    }
    
    //helper functions
    private boolean checkRowsForWin()
    {
       
        for(int i=0; i<3; i++)
        {
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] )
                return true;
        }
        return false;
    }
    
    public boolean checkColumnsForWin()
    {
        for(int j=0; j<3; j++)
        {
           
            if(board[0][j]==board[1][j] && board[1][j]==board[2][j])
                return true;
        }
        return false;
    }
    
    public boolean checkDiagForWin()
    {
        
            if( (board[0][0]==board[1][1] && board[1][1]==board[2][2])
                || (board[0][2]==board[1][1] && board[1][1]==board[2][0]) )
                return true;
           
        return false;
    }
    
    public void changePlayer()
    {
        if(currentPlayer == 'x')
            currentPlayer = 'o';
        else
            currentPlayer = 'x';
    }
    
    public boolean placeMark(int pos)
    {
        if(pos >=1 && pos <=9)
        {
            switch(pos)
            {
                case 1: board[2][0] = currentPlayer;
                        break;
                case 2: board[2][1]= currentPlayer;
                        break;
                case 3: board[2][2] = currentPlayer;
                        break;
                case 4: board[1][0] = currentPlayer;
                        break;
                case 5: board[1][1] = currentPlayer;
                        break;
                case 6: board[1][2] = currentPlayer;
                        break;
                case 7: board[0][0] = currentPlayer;
                        break;
                case 8: board[0][1] = currentPlayer;
                        break;  
                case 9: board[0][2] = currentPlayer;
                        break;
            }
            
            return true;
        }
        return false;
    }
    
    public char getCurrentPlayer()
    {
        return currentPlayer;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scr = new Scanner(System.in);
        char decision;
       do{
        TicTacToe game = new TicTacToe();
        System.out.println("--------Tic-Tac-Toe--------");
        char mark = 'x';
        game.setCurrentPlayer(mark);
        do
        {
            game.printBoard();
            int pos;
        
        do{
            System.out.println("Player "+game.getCurrentPlayer()+" enter a number (1 to 9) to indicate a position on the board: ");
            pos = scr.nextInt();
            
        }
        while(!game.placeMark(pos));
        game.changePlayer();
        
        }while(!game.checkForWin() && !game.isBoardFull());
        
        if(game.checkForWin() && !game.isBoardFull())
        {
            //System.out.println("Game stop!");
            game.printBoard();
            game.changePlayer();
            System.out.println("Player "+Character.toUpperCase(game.getCurrentPlayer())+" Won!");
        }
        else
        {
            System.out.println("Cat's Game!");
        }
        System.out.println("Do you want to continue playing?(Enter Y/N)");
        decision = scr.next().charAt(0);
        
       }while(Character.toUpperCase(decision) == 'Y');
    }
      
}
