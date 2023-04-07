package finalProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyWindow extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
}
