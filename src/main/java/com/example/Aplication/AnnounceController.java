package com.example.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AnnounceController {
    @Autowired
    private AnnounceService announceService;

    @GetMapping("/findAnnounce/{id}")
    public Announce findAnnounce(@PathVariable("id") Long id){
        return announceService.findAnnounce(id);
    }

    @GetMapping("/fetchAnnounceList")
    public List<Announce> fetchUserList(){
        return announceService.fetchAnnounceList();
    }

    @PutMapping("/updateAnnounce/{id}")
    public Announce
    updateUser(@RequestBody Announce announce,
               @PathVariable("id") Long id)
    {

        return announceService.updateAnnounce(
                announce, id);
    }

    @DeleteMapping("/announceDelete/{id}")
    public String deleteUserById(@PathVariable("id")
                                 Long userId)
    {

        announceService.deleteAnnounce(
                userId);
        return "Deleted Successfully";
    }

    @PostMapping("/saveAnnounce")
    public Announce saveUser(
            @RequestBody Announce announce)
    {

        return announceService.saveAnnounce(announce);
    }
}
