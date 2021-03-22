package XOandHomework8.Core.impl;

import XOandHomework8.Domain.MatrixCoordinate;
import XOandHomework8.enums.DotType;

public interface GameService {

    MatrixCoordinate aiTurn();

    void humanTurn(int rowIndex, int columnIndex);

    boolean checkWin(DotType dotType);

    boolean isMapFull();

}
