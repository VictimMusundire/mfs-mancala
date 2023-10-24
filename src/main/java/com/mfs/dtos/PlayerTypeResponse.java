package com.mfs.dtos;


import static com.mfs.utils.Values.*;

public enum PlayerTypeResponse {
    PLAYER_ONE(0), PLAYER_TWO(1);

    public final int playerTypeValue;

    PlayerTypeResponse(int playerTypeValue) {
        this.playerTypeValue = playerTypeValue;
    }

    public static PlayerTypeResponse oppositeType(PlayerTypeResponse playerType) {
        return playerType.equals(PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
    }

    public static int getLimitBoardPlayerType(PlayerTypeResponse playerType) {
        return PLAYER_ONE.equals(playerType) ? LIMIT_BOARD_PLAYER_ONE : LIMIT_BOARD_PLAYER_TWO;
    }
}
