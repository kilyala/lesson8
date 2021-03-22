package Project.factory;

import Project.Core.impl.GameService;
import Project.Core.impl.GameServiceImpl;
import Project.enums.DotType;

public class GameFactory {

    public static GameService getGameService(int mapsize, DotType playerType) {
        return new GameServiceImpl(mapsize, playerType);
    }
}
