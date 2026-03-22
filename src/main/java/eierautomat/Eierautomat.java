package eierautomat;

import java.util.ArrayList;

import pi.Rectangle;
import pi.Scene;

class Eierautomat
{
    protected ArrayList<Eierkarton> eierkartons;

    Scene scene;

    Eierautomat(Scene scene)
    {
        Rectangle automat = new Rectangle();
        automat.size(4, 10);
        automat.color("grau");
        automat.center(0, 0);
        eierkartons = new ArrayList<Eierkarton>();
        this.scene = scene;
        scene.add(automat);
    }

    protected void fügeEierkartonHinzu(int fach)
    {
        Eierkarton eierkarton = new Eierkarton();
        eierkarton.center(0, 4 - 0.8 * fach);
        scene.add(eierkarton);
        eierkartons.add(eierkarton);
    }

    protected Eierkarton entferneEierkarton()
    {
        Eierkarton gekaufterKarton = eierkartons.remove(0);
        scene.remove(gekaufterKarton);
        return gekaufterKarton;
    }

    synchronized boolean befülle()
    {
        if (eierkartons.size() == 0)
        {
            for (int i = 0; i < 10; i++)
            {
                fügeEierkartonHinzu(i);
            }
            return true;
        }
        return false;
    }

    synchronized Eierkarton holeEier()
    {
        if (eierkartons.size() > 0)
        {
            return entferneEierkarton();
        }
        return null;
    }
}
