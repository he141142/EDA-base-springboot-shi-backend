package com.example.demo.transport.rest;

import com.example.demo.domain.Sport;
import com.example.demo.domain.Team;
import com.example.demo.core.ports.services.ISportService;
import com.example.demo.dto.Paginate;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/sport")
@RestController
public class SportAPI {

    ISportService sportService;

    @Autowired
    public void setSportService(ISportService sportService) {
        this.sportService = sportService;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> GetTeamsByCountryCode(@RequestParam("iso") String iso) throws Exception {
        System.out.println("GetTeamsByCountryCode");
        return new ResponseEntity<>(sportService.GetAllTeamsByCountryCode(iso), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Paginate<Sport, List<Sport>>> ListSports(
            @Nonnull @RequestParam("page") Integer page,
            @Nonnull @RequestParam("size") Integer size) throws Exception {
        return new ResponseEntity<>(sportService.GetAllSports(page, size), new HttpHeaders(), HttpStatus.OK);
    }
}
