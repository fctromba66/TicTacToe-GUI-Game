/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeguigame;

import games.board.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Francis Cuccio
 */
public class TicTacToeGUIGame extends JFrame {
    private final Board gb;
    private int turn;
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable () {
            @Override
            public void run() { new TicTacToeGUIGame();}
        });
    }
    
    private void takeTurn(Cell c) {
        Mark curMark = (turn++ % 2 == 0) ?Mark.NOUGHT: Mark.CROSS;
        gb.setCell(curMark, c.getRow(), c.getColumn());
    }
    
    private TicTacToeGUIGame() {
        gb = new Board(3, 3, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               Cell c = (Cell) ae.getSource();
               takeTurn(c);
           }
        });
        this.add(gb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TIC-TAC-TOE");
        this.setSize(300, 300);
        this.setVisible(true);
    }
    
    private void getOutcome() {
        
    }
}
