package scr.lab11;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


    public class JCanvas extends JPanel{

        private BufferedImage[][] ims;
            public static int side=100;

        public JCanvas()  {

            ims=new BufferedImage[3][3];
            try {

                for(int i=0;i<3;i++)
                {
                  for(int j=0;j<3;j++)
                  {
                      ims[i][j] = ImageIO.read(new File("img\\поле51.jpg"));
                  }
                }

            } catch (IOException ex) {
                System.err.println(ex.toString());
                // handle exception...
            }
            this.setBounds(10,10,10+side*3,10+side*3);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    g.drawImage(ims[i][j], j*(side+1), i*(side+1), this);
                }
            }

        }
        public void setState(Type type,int x,int y)
        {
            try {
                switch (type) {
                    case CROSS:
                        ims[y][x] = ImageIO.read(new File("img\\cross1.jpg"));
                        break;
                    case CIRCLE:
                        ims[y][x] = ImageIO.read(new File("img\\circle1.jpg"));
                        break;
                    case EMPTY:
                        ims[y][x] = ImageIO.read(new File("img\\поле51.jpg"));
                        break;

                }
            }

            catch (IOException ex) {
                System.err.println(ex.toString());
                // handle exception...
            }
            this.repaint();
            this.revalidate();//проверит,что нет NULL ссылок
        }


    }
