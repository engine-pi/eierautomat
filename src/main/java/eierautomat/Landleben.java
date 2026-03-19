package eierautomat;

import pi.Controller;
import pi.Scene;

class Landleben extends Scene
{
    Landleben()
    {
        Eierautomat automat = new Eierautomat(this);
        // Eierautomat automat = new BessererEierautomat(this);
        Baeuerin baeuerin = new Baeuerin(this, automat);
        Leo leo = new Leo(this, automat);
        baeuerin.start();
        leo.start();
    }

    public static void main(String[] args)
    {
        Controller.instantMode(false);
        // Ein Objekt der Klasse Landleben erzeugen und als Parameter der Methode Controller.start() übergeben.
        // Controller.start();
    }
}
