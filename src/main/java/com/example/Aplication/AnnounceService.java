package com.example.Aplication;

import java.util.List;

public interface AnnounceService {
    Announce saveAnnounce(Announce announce);
    List<Announce> fetchAnnounceList();
    Announce updateAnnounce(Announce announce, Long announceId);
    Announce findAnnounce(Long id);
    void deleteAnnounce(Long id);
}
