package com.dsi.spring.controller;

import com.dsi.spring.dto.ClubDto;
import com.dsi.spring.model.Club;
import com.dsi.spring.service.ClubServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private ClubServices clubServices;



    @GetMapping("/clubs")
    public List<ClubDto> listClubs(){
        return clubServices.findAllClubs();
    }

    @GetMapping("/clubs/new")
    public String createClub(){
        return "club-created";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@RequestBody Club club){
        clubServices.save(club);
        return "created";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public ClubDto editClubForm(@PathVariable("clubId") long clubId){
        return clubServices.findClubById(clubId);

    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateInfo(@PathVariable("clubId")long clubId,@RequestBody ClubDto club){
        club.setId(clubId);
        clubServices.updateInfo(club);
        return "updated";
    }
}
