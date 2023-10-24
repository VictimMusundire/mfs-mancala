package com.mfs.controllers;

import com.mfs.dtos.EndGameRequestDTO;
import com.mfs.dtos.MoveRequestDTO;
import com.mfs.dtos.StartRequestDTO;
import com.mfs.dtos.EndGameResponseDTO;
import com.mfs.dtos.MancalaResponseDTO;
import com.mfs.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(path = "/start")
    public ResponseEntity<MancalaResponseDTO> beginGame(@RequestBody StartRequestDTO startRequestDTO) {
        log.info("Starting board");
        return ResponseEntity.ok(gameService.startGame(startRequestDTO));
    }

    @PostMapping(path = "/play")
    public ResponseEntity<MancalaResponseDTO> playGame(@RequestBody MoveRequestDTO moveRequestDTO) {
        log.info("Pit move number: " + moveRequestDTO.getPit());
        return ResponseEntity.ok(gameService.makeMove(moveRequestDTO));
    }

    @PostMapping(path = "/end")
    public ResponseEntity<EndGameResponseDTO> finishGame(@RequestBody EndGameRequestDTO endGameRequestDTO) {
        log.info("The End");
        return ResponseEntity.ok(gameService.endGame(endGameRequestDTO));
    }

}