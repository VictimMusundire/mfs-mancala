package com.mfs;

import com.mfs.controllers.GameController;
import com.mfs.dtos.EndGameRequestDTO;
import com.mfs.dtos.MoveRequestDTO;
import com.mfs.dtos.StartRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GameControllerUnitTest {
    private final MancalaMockData mancalaMockData = new MancalaMockData();

    @Mock
    private GameController gameController;

    @Test
    public void testStartGame() {
        when(gameController.beginGame(any(StartRequestDTO.class)))
                .thenReturn(ResponseEntity.ok(mancalaMockData.mancalaResponseDTO));

        gameController.beginGame(mancalaMockData.startRequestDTO);

        verify(gameController, times(1))
                .beginGame(mancalaMockData.startRequestDTO);
    }

    @Test
    public void testMakeMove() {
        when(gameController.playGame(any(MoveRequestDTO.class)))
                .thenReturn(ResponseEntity.ok(mancalaMockData.mancalaResponseDTO));

        gameController.playGame(mancalaMockData.moveRequestDTO);

        verify(gameController, times(1))
                .playGame(mancalaMockData.moveRequestDTO);
    }

    @Test
    public void testEndGame() {
        when(gameController.finishGame(any(EndGameRequestDTO.class)))
                .thenReturn(ResponseEntity.ok(mancalaMockData.endGameResponseDTO));

        gameController.playGame(mancalaMockData.moveRequestDTO);

        verify(gameController, times(1))
                .playGame(mancalaMockData.moveRequestDTO);
    }
}
