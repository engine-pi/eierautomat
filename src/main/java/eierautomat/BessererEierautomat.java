package eierautomat;

import pi.Scene;

class BessererEierautomat extends Eierautomat
{
    BessererEierautomat(Scene scene)
    {
        super(scene);
    }

    @Override
    synchronized void befülle()
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
    }

    @Override
    synchronized Eierkarton holeEier()
    {
        // Wenn eine bestimmte Bedingung gilt, müssen Abholer abwarten
        // --- HIER PROGRAMMCODE ERGÄNZEN
        // --- HINWEIS: Die Bedingung um die folgenden Anweisungen könnte dann
        // entfernt werden,
        // --- ebenso die Rückgabe der leeren Referenz.

        if (eierkartons.size() > 0)
        {
            // Ein Eierkarton wird aus dem Feld entfernt und seine Darstellung
            // aus dem Zeichenfenster
            Eierkarton gekaufterKarton = entferneEierkarton();

            // Unter einer bestimmten Bedingung muss die Bäuerin informiert
            // werden
            // --- HIER PROGRAMMCODE ERGÄNZEN

            return gekaufterKarton;
        }
        return null;

    }
}
