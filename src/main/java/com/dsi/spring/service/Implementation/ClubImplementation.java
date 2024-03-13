package com.dsi.spring.service.Implementation;

import com.dsi.spring.dto.ClubDto;
import com.dsi.spring.exceptions.notFound;
import com.dsi.spring.model.Club;
import com.dsi.spring.repository.ClubRepository;
import com.dsi.spring.service.ClubServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubImplementation implements ClubServices {

    @Autowired
    private ClubRepository clubRepository;


    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClub).collect(Collectors.toList());
    }

    private ClubDto mapToClub(Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .updatedOn(club.getUpdatedOn())
                .build();
    }

    @Override
    public Club save(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long id) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new notFound("Pokemon not found by this id"));
        return mapToClub(club);
    }

    @Override
    public void updateInfo(ClubDto club) {
        Club club1 = mapTo(club);
        clubRepository.save(club1);
    }

    private Club mapTo(ClubDto club) {
        return Club
                .builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .photoUrl(club.getPhotoUrl())
                .build();
    }
}
