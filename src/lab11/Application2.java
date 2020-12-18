package src.lab11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Application2 extends JFrame {
    public JCanvas map;
    private Game gameManager;
    private JCheckBox isAI;
    public Application2() {
        setTitle("x/o");
        gameManager=new Game();
        map=new JCanvas();
        add(map,BorderLayout.CENTER);
        redrawMap();
        map.addMouseListener(new GameMouseListener());
        // Создаём панель для кнопок табличного стиля
        JPanel buttonPanel = new JPanel(new GridLayout());

        // Панель для кнопок добавляем вниз формы
        add(buttonPanel, BorderLayout.SOUTH);
         isAI=new JCheckBox("Играть с ИИ");
         buttonPanel.add(isAI);
        JButton restart= new JButton("restart");
        buttonPanel.add(restart);
        restart.setVisible(true);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.resetGame();
                redrawMap();
            }
        });
        setSize(400,400);
       // setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //каждый раз рисует карту с нуля
    public void redrawMap(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(gameManager.getCellState(j,i)==0)
                    map.setState(oldschool.lab11.Type.EMPTY,j,i);
                if(gameManager.getCellState(j,i)==1)
                    map.setState(oldschool.lab11.Type.CROSS,j,i);
                if(gameManager.getCellState(j,i)==2)
                    map.setState(oldschool.lab11.Type.CIRCLE,j,i);
            }
        }
    }
    public void showEndGameMsg(){
        String msg="";
        switch(gameManager.getGameState())
        {
            case PLAYER1_WIN:
                msg="Победили крестики";
                break;
            case PLAYER2_WIN:
                msg="Победили нолики";
                break;
            case DRAW:
                msg="Ничья";
                break;
        }
        JOptionPane.showMessageDialog(this, msg);
    }
    public static void main(String[] args) {
        Application2 frame = new Application2();


    }
    class GameMouseListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()/JCanvas.side;
                int y = e.getY()/JCanvas.side;
                gameManager.setCell(x,y);
                redrawMap();
                if(isAI.isSelected())
                {
                    gameManager.doAITurn();
                    redrawMap();
                }
                if(gameManager.getGameState()!=GameState.GAME) showEndGameMsg();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }

    }

}
