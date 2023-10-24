package com.mfs.mappers;

import com.mfs.dtos.MoveRequestDTO;
import com.mfs.dtos.PlayerRequestDTO;
import com.mfs.dtos.StartRequestDTO;
import com.mfs.dtos.BoardResponseDTO;
import com.mfs.dtos.EndGameResponseDTO;
import com.mfs.dtos.MancalaResponseDTO;
import com.mfs.dtos.PlayerEndGameResponseDTO;
import com.mfs.dtos.PlayerResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static com.mfs.dtos.PlayerTypeResponse.PLAYER_ONE;
import static com.mfs.dtos.PlayerTypeResponse.PLAYER_TWO;

@Slf4j
@Component
public class GameMapper {

    public MancalaResponseDTO startRequestDTOToMancalaResponseDTO(StartRequestDTO startRequestDTO, boolean turn, BoardResponseDTO boardResponseDTO) {
        if (startRequestDTO == null || boardResponseDTO == null) {
            log.info("Something went wrong in " + GameMapper.class.getSimpleName());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong in " + GameMapper.class.getSimpleName());
        }

        final List<PlayerResponseDTO> playerResponseDTOs = new ArrayList<>();

        for (PlayerRequestDTO player : startRequestDTO.getPlayers()) {
            final PlayerResponseDTO playerResponseDTO = playerResponseDTOs.isEmpty() ?
                    new PlayerResponseDTO(player.getName(), PLAYER_ONE, turn, boardResponseDTO) :
                    new PlayerResponseDTO(player.getName(), PLAYER_TWO, !turn, boardResponseDTO);

            playerResponseDTOs.add(playerResponseDTO);
        }

        return MancalaResponseDTO.builder()
                .players(playerResponseDTOs)
                .gameEnded(false)
                .build();
    }

    public MancalaResponseDTO moveRequestDTOToMancalaResponseDTO(MoveRequestDTO moveRequestDTO, boolean isEndedGame) {
        if (moveRequestDTO == null) {
            log.info("Something went wrong in " + GameMapper.class.getSimpleName());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong in " + GameMapper.class.getSimpleName());
        }

        final List<PlayerResponseDTO> playerResponseDtos = moveRequestDTO.getPlayers().stream()
                .map(player -> PlayerResponseDTO.builder()
                        .playerType(player.getPlayerType())
                        .isPlayerTurn(player.isPlayerTurn())
                        .name(player.getName())
                        .board(player.getBoard())
                        .build())
                .collect(Collectors.toList());

        return new MancalaResponseDTO(playerResponseDtos, isEndedGame);
    }

    public EndGameResponseDTO endGameRequestDTOToEndGameResponse(boolean isTie, List<PlayerEndGameResponseDTO> players) {
        if (players == null) {
            log.info("Something went wrong in " + GameMapper.class.getSimpleName());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong in " + GameMapper.class.getSimpleName());
        }
        return new EndGameResponseDTO(isTie, players);
    }
}