package com.mfs.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PlayerMoveRequestDTO {
    private String name;
    private PlayerTypeResponse playerType;
    private boolean isPlayerTurn;
    private BoardResponseDTO board;

}
