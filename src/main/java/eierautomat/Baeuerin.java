package eierautomat;

import java.util.Random;

import pi.Scene;
import pi.Text;

class Baeuerin extends Thread
{

    Random zufallsgenerator;

    int anzahlVersuche;

    Text text;

    Eierautomat automat;

    Baeuerin(Scene scene, Eierautomat eierautomat)
    {
        automat = eierautomat;
        zufallsgenerator = new Random();
        text = new Text("");
        text.center(-10, 2);
        anzahlVersuche = 0;
        scene.add(text);
    }

    @Override
    public void run()
    {
        while (true)
        {
            anzahlVersuche += 1;
            text.content(anzahlVersuche + ". Befüllbesuch");

            automat.befülle();

            try
            {
                sleep(500 + zufallsgenerator.nextInt(4000));
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
