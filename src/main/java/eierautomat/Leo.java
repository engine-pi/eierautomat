package eierautomat;

import java.util.Random;

import pi.Scene;
import pi.Text;

class Leo extends Thread
{
    Random zufallsgenerator;

    int anzahlVersuche;

    Text text;

    int anzahlVergeblicheVersuche;

    Text textVergeblich;

    Eierautomat automat;

    Leo(Scene scene, Eierautomat eierautomat)
    {
        automat = eierautomat;
        zufallsgenerator = new Random();

        text = new Text("");
        text.center(3, 2);

        textVergeblich = new Text("");
        textVergeblich.height(0.8).center(3, 0).color("rot");

        scene.add(text, textVergeblich);
    }

    @Override
    public void run()
    {
        while (true)
        {
            anzahlVersuche += 1;
            text.content(anzahlVersuche + ". Eierholbesuch");

            Eierkarton karton = automat.holeEier();

            if (karton == null)
            {
                anzahlVergeblicheVersuche++;
                textVergeblich.content(
                    anzahlVergeblicheVersuche + ". vergeblicher Eierholbesuch");
            }

            try
            {
                sleep(10 + zufallsgenerator.nextInt(150));
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
