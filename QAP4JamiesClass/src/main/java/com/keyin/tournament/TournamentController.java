package com.keyin.tournament;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class TournamentController {

    @Autowired
    TournamentRepository tournaments;

    @GetMapping("/tournaments")
    public List<Tournament> getallTournaments() {
        return tournaments.findAll();
    }

    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentById(@PathVariable String id) {
        return tournaments.getReferenceById(Integer.parseInt(id));
    }

    @PostMapping("/tournaments")
    public void createtournament(@RequestBody Tournament tournament) {tournaments.save(tournament);}

    @PutMapping("/tournaments/{id}")
    public void updateTournamentLocation(@PathVariable String id, @RequestBody Tournament tournament, HttpServletResponse response) {
        // finding tournament with id in database
        Optional<Tournament> returnValue = tournaments.findById(Integer.parseInt(id));
        Tournament tournamentToUpdate;

        if(returnValue.isPresent()) {
        tournamentToUpdate = returnValue.get();
        tournamentToUpdate.setLocation(tournament.getLocation());
        tournaments.save(tournamentToUpdate);
        } else {
            try {
                response.sendError(404, "Tournament with id: " + tournament.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @DeleteMapping("/tournaments/{id}")
    public void deleteTournament(@PathVariable String id) {
        tournaments.deleteById(Integer.parseInt(id));
    }

}
