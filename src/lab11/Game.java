package scr.lab11;

public class Game {
    private int mas[][]=new int[3][3];
    private int player=1;
    private GameState gameState ;

    public Game()
    {
        resetGame();
    }
    public boolean isWin(){
        for(int i=0;i<3;i++)
        {
           if(mas[0][i]==mas[1][i] && mas[1][i]==mas[2][i] && mas[0][i]==player)
           {
               return true;
           }
            if(mas[i][0]==mas[i][1] && mas[i][1]==mas[i][2] && mas[i][0]==player)
            {
                return true;
            }
        }
        if(mas[0][0]==mas[1][1] && mas[1][1]==mas[2][2] && mas[0][0]==player)
        {
            return true;
        }
        if(mas[0][2]==mas[1][1] && mas[1][1]==mas[2][0] && mas[0][2]==player)
        {
            return true;
        }
        return false;
    }
    public boolean setCell(int x,int y) {
        if(x<0 || x>=3 || y<0 || y>=3) return  false;
        if (mas[y][x] != 0 || gameState != GameState.GAME) return false;
        mas[y][x] = player;
        if (isWin()) gameState = player == 1 ? GameState.PLAYER1_WIN : GameState.PLAYER2_WIN;
        player=2-(player+1)%2;//переключаем игрока
        checkDraw();
        return true;
    }
    public  void checkDraw(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mas[i][j]==0) return;
            }
        }
        gameState=GameState.DRAW;

    }
    public GameState getGameState(){
        return gameState;
    }
    public int getCellState(int x,int y){
        if(x<0 || x>=3 || y<0 || y>=3) return 0;
        return mas[y][x];

    }
    //сброс игры до нач сост
    public void resetGame(){
        player=1;
        gameState=GameState.GAME;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                mas[i][j]=0;
    }
    public void doAITurn(){
        //Попытка победить в один ход
        if(doOptimalTurn(player))
            return;
        //Попытка не проиграть в один ход
        if(doOptimalTurn(2-(player+1)%2))
            return;
        //Делает рандомный ход
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(mas[i][j]==0) {
                    setCell(j, i);
                    return;
                }
    }
    private boolean winIsNear(int x,int y,int dx,int dy,int symbol)
    {
        int count = 0;
        for (int i = 0; i < 3; i++)
            if (mas[y + i * dy][x + i * dx] == symbol )
                count++;
        return count==2;
    }
    private boolean doOptimalTurn(int symbol)
    {
        for(int i=0;i<3;i++){
            //Проверка столбца
            if(winIsNear(i,0,0,1,symbol))
                for(int j=0;j<3;j++){
                    if(mas[j][i] == 0) {
                        setCell(i, j);
                        return true;
                    }
                }
            //Проверка строки
            if(winIsNear(0,i,1,0,symbol))
                for(int j=0;j<3;j++){
                    if(mas[i][j] == 0) {
                        setCell(j, i);
                        return true;
                    }
                }
        }
        //Проверка главной диагонали
        if(winIsNear(0,0,1,1,symbol))
            for(int j=0;j<3;j++){
                if(mas[j][j] == 0) {
                    setCell(j, j);
                    return true;
                }
            }
        //Проверка побочной диагонали
        if(winIsNear(2,0,-1,1,symbol))
            for(int j=0;j<3;j++){
                if(mas[j][2-j] == 0) {
                    setCell(2-j, j);
                    return true;
                }
            }
        return false;
    }

}
