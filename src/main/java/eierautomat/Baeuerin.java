package eierautomat;

import java.util.Random;

import pi.Scene;
import pi.actor.Counter;
import pi.actor.Image;

class Baeuerin extends Thread
{
    Random zufallsgenerator;

    Counter versuche;

    Counter vergeblicheVersuche;

    Eierautomat automat;

    Baeuerin(Scene scene, Eierautomat eierautomat)
    {
        automat = eierautomat;
        zufallsgenerator = new Random();

        scene.add(
            new Image("eierautomat/baeuerin.png", 6, 6).center(-7, 3));

        versuche = new Counter().suffix(". Befüllbesuch");
        versuche.anchor(-11, -2);
        scene.add(versuche);

        vergeblicheVersuche = new Counter()
            .suffix(". vergeblicher Befüllbesuch");
        vergeblicheVersuche.height(0.8).color("green").anchor(-11, -4);
        scene.add(vergeblicheVersuche);
    }

    @Override
    public void run()
    {
        while (true)
        {
            boolean erfolgreich = automat.befülle();

            if (!erfolgreich)
            {
                vergeblicheVersuche.increase();
                vergeblicheVersuche.color("red");
            }

            versuche.increase();

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
