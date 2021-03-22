package XOandHomework8.factory;

import XOandHomework8.Core.impl.GameService;
import XOandHomework8.Core.impl.GameServiceImpl;
import XOandHomework8.enums.DotType;

public class GameFactory {

    public static GameService getGameService(int mapsize, DotType playerType) {
        return new GameServiceImpl(mapsize, playerType);
    }
}
