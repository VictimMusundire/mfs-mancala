package com.mfs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfs.dtos.*;

import java.util.Arrays;
import java.util.List;

import static com.mfs.dtos.PlayerTypeResponse.PLAYER_ONE;
import static com.mfs.dtos.PlayerTypeResponse.PLAYER_TWO;


public class MancalaMockData {

    private static MancalaMockData mancalaMockData;

    public static MancalaMockData getInstance() {
        if (mancalaMockData == null) {
            mancalaMockData = new MancalaMockData();
        }
        return mancalaMockData;
    }

    public static final String PLAYER_ONE_NAME = "Lalo";
    public static final String PLAYER_TWO_NAME = "Carlos";

    public static final int[] PLAYER_INIT_BOARD = new int[]{6, 6, 6, 6, 6, 6};
    public static final int[] BOARD_FULL_ZERO = new int[]{0, 0, 0, 0, 0, 0};
    public static final int[] FULL_BOARD = new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
    public static final int[] PLAYER_ONE_BOARD_RANDOM_STONES = new int[]{4, 10, 3, 6, 8, 4};
    public static final int[] PLAYER_TWO_BOARD_RANDOM_STONES = new int[]{3, 0, 8, 7, 11, 1};
    public static final int[] FULL_BOARD_RANDOM_STONES = new int[]{4, 10, 3, 6, 8, 4, 3, 0, 8, 7, 11, 1};
    public static final int ZERO_BIG_PIT = 0;
    public static final int GREATEST_BIG_PIT = 37;
    public static final int LOWEST_BIG_PIT = 35;
    public static final int EQUAL_BIG_PIT = 30;
    public static final int START_BOARD_PLAYER_ONE = 0;
    public static final int LIMIT_BOARD_PLAYER_ONE = 6;
    public static final int START_BOARD_PLAYER_TWO = 7;
    public static final int LIMIT_BOARD_PLAYER_TWO = 12;

    public BoardResponseDTO boardResponseDTO = BoardResponseDTO.builder()
            .bigPit(ZERO_BIG_PIT)
            .pits(PLAYER_INIT_BOARD)
            .build();

    public List<PlayerMoveRequestDTO> playerMoveRequestDTOList = Arrays.asList(
            PlayerMoveRequestDTO.builder()
                    .playerType(PLAYER_ONE)
                    .name(PLAYER_ONE_NAME)
                    .isPlayerTurn(true)
                    .board(boardResponseDTO).build(),
            PlayerMoveRequestDTO.builder()
                    .playerType(PLAYER_TWO)
                    .name(PLAYER_TWO_NAME)
                    .isPlayerTurn(false)
                    .board(boardResponseDTO).build()
    );

    public MoveRequestDTO moveRequestDTO = MoveRequestDTO.builder()
            .pit(1)
            .players(playerMoveRequestDTOList)
            .build();

    public StartRequestDTO startRequestDTO = StartRequestDTO.builder()
            .players(Arrays.asList(
                    PlayerRequestDTO.builder()
                            .name(PLAYER_ONE_NAME)
                            .build(),
                    PlayerRequestDTO.builder()
                            .name(PLAYER_TWO_NAME)
                            .build()))
            .build();


    public List<PlayerResponseDTO> playerResponseDTOList = Arrays.asList(
            PlayerResponseDTO.builder()
                    .playerType(PLAYER_ONE)
                    .name(PLAYER_ONE_NAME)
                    .isPlayerTurn(false)
                    .board(
                            BoardResponseDTO.builder()
                                    .bigPit(1).
                                    pits(new int[]{6, 0, 7, 7, 7, 7}).build()
                    ).build(),
            PlayerResponseDTO.builder()
                    .playerType(PLAYER_TWO)
                    .name(PLAYER_TWO_NAME)
                    .isPlayerTurn(true)
                    .board(
                            BoardResponseDTO.builder()
                                    .bigPit(0).
                                    pits(new int[]{7, 6, 6, 6, 6, 6}).build()
                    ).build()
    );

    public MancalaResponseDTO mancalaResponseDTO = MancalaResponseDTO.builder()
            .players(playerResponseDTOList)
            .gameEnded(false)
            .build();

    public List<PlayerEndGameRequestDTO> playerEndGameRequestDTOList = Arrays.asList(
            PlayerEndGameRequestDTO.builder()
                    .name(PLAYER_ONE_NAME)
                    .bigPit(GREATEST_BIG_PIT)
                    .build(),
            PlayerEndGameRequestDTO.builder()
                    .name(PLAYER_TWO_NAME)
                    .bigPit(LOWEST_BIG_PIT)
                    .build());

    public EndGameRequestDTO endGameRequestDTO = EndGameRequestDTO.builder()
            .players(playerEndGameRequestDTOList)
            .build();


    public List<PlayerEndGameResponseDTO> playerEndGameResponseDTOS = Arrays.asList(
            PlayerEndGameResponseDTO.builder()
                    .bigPit(GREATEST_BIG_PIT)
                    .name(PLAYER_ONE_NAME)
                    .winner(true)
                    .build(),
            PlayerEndGameResponseDTO.builder()
                    .bigPit(LOWEST_BIG_PIT)
                    .name(PLAYER_TWO_NAME)
                    .winner(false)
                    .build()
    );

    public EndGameResponseDTO endGameResponseDTO = EndGameResponseDTO.builder()
            .players(playerEndGameResponseDTOS)
            .tie(false)
            .build();


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
