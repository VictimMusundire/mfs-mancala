package com.mfs.dtos;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StartRequestDTO {
    private List<PlayerRequestDTO> players;
}

