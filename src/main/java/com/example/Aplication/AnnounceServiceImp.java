package com.example.Aplication;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class AnnounceServiceImp implements AnnounceService{

    @Autowired private AnnounceRepository announceRepository;
    @Override
    public Announce saveAnnounce(Announce announce) {
        return announceRepository.save(announce);
    }

    @Override
    public List<Announce> fetchAnnounceList() {
        return (List<Announce>) announceRepository.findAll();
    }

    @Override
    public Announce updateAnnounce(Announce announce, Long announceId) {
        Announce depDB = announceRepository.findById(announceId.intValue()).get();

        if (Objects.nonNull(announce.getTitulo()) && !"".equalsIgnoreCase(announce.getTitulo())) {
            depDB.setTitulo(announce.getTitulo());
        }

        if (Objects.nonNull(announce.getDescription()) && !"".equalsIgnoreCase(announce.getDescription())) {
            depDB.setDescription(announce.getDescription());
        }

        if (Objects.nonNull(announce.getDireccion()) && !"".equalsIgnoreCase(announce.getDireccion())) {
            depDB.setDireccion(announce.getDireccion());
        }

        return announceRepository.save(depDB);
    }

    @Override
    public Announce findAnnounce(Long id) {
        return announceRepository.findById(id.intValue()).get();
    }

    @Override
    public void deleteAnnounce(Long id) {
        announceRepository.deleteById(id.intValue());
    }
}
