package eierautomat;

import java.util.Random;

import pi.Scene;
import pi.actor.Text;
import pi.actor.Counter;
import pi.actor.Image;

class Leo extends Thread
{
    Random zufallsgenerator;

    Counter versuche;

    Counter vergeblicheVersuche;

    Text textVergeblich;

    Eierautomat automat;

    Leo(Scene scene, Eierautomat eierautomat)
    {
        automat = eierautomat;
        zufallsgenerator = new Random();

        scene.add(new Image("leo.png", 4, 4).center(6, 3));

        versuche = new Counter().suffix(". Eierholbesuch");
        versuche.anchor(3, -2);
        scene.add(versuche);

        vergeblicheVersuche = new Counter()
            .suffix(". vergeblicher Eierholbesuch");
        vergeblicheVersuche.height(0.8).anchor(3, -4).color("green");
        scene.add(vergeblicheVersuche);
    }

    @Override
    public void run()
    {
        while (true)
        {
            Eierkarton karton = automat.holeEier();

            versuche.increase();

            if (karton == null)
            {
                vergeblicheVersuche.increase();
                vergeblicheVersuche.color("red");
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
