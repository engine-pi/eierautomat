package eierautomat;

import pi.Scene;

class BessererEierautomat extends Eierautomat
{
    BessererEierautomat(Scene scene)
    {
        super(scene);
    }

    @Override
    synchronized boolean befülle()
    {
        if (eierkartons.size() > 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }

        for (int i = 0; i < 10; i++)
        {
            fügeEierkartonHinzu(i);
        }

        notify();
        return true;
    }

    @Override
    synchronized Eierkarton holeEier()
    {
        // solange eine bestimmte Bedingung gilt, müssen Abholer abwarten
        // Die Bedingung um die folgenden Anweisungen könnte dann
        // entfernt werden, ebenso die Rückgabe der leeren Referenz.

        if (eierkartons.size() > 0)
        {
            // Ein Eierkarton wird aus dem Feld entfernt und seine Darstellung
            // aus dem Zeichenfenster
            Eierkarton gekaufterKarton = entferneEierkarton();

            // Unter einer bestimmten Bedingung muss die Bäuerin informiert
            // werden.

            return gekaufterKarton;
        }
        return null;

    }
}
