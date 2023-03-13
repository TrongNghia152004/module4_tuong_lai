package com.example.service.impl;

import com.example.dto.SongDTO;
import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<SongDTO> findAll() {
        List<Song> songList = songRepository.findAll();
        List<SongDTO> songDTOList = new ArrayList<>();
        SongDTO songDTO;
        for (Song song : songList) {
            songDTO = new SongDTO();
            songDTO.setId(song.getId());
            songDTO.setSongName(song.getSongName());
            songDTO.setCategory(song.getCategory());
            songDTO.setSinger(song.getSinger());
            songDTOList.add(songDTO);
        }
        return songDTOList;
//        return songList.stream().map(song -> mapper.map(song, SongDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void creatSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }
}
