package com.dsi.spring.service;

import com.dsi.spring.dto.ClubDto;
import com.dsi.spring.model.Club;

import java.util.List;

public interface ClubServices {
    List<ClubDto> findAllClubs();
    Club save(Club club);
    ClubDto findClubById(long id);

    void updateInfo(ClubDto club);
}
