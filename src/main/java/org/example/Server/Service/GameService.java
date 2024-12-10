package org.example.Server.Service;

import org.example.Interface.IGameService;
import org.example.Server.Model.Robot;

//extends/ implements?
public class GameService extends IGameService {
    @Override
    public Robot getRobot() {
        return null;
    }



    //Keine Validierung im Service zur Datenbank sondern vorher, hier davon ausgehen das die Daten bereits korrekt sind
}
