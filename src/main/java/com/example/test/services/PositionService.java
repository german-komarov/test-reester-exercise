package com.example.test.services;

import com.example.test.entities.Position;
import com.example.test.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;


    public List<Position> getAllPositions()
    {
        return positionRepository.findAll();
    }

    public Position getPositionById(Long id)
    {
        Optional<Position> position=positionRepository.findById(id);
        return position.orElse(null);
    }


    public void deletePositionById(Long id)
    {
        positionRepository.deleteById(id);
    }

    public void savePosition(Position position)
    {
        positionRepository.save(position);
    }

    public Position getPositionByName(String name)
    {
        Optional<Position> position=positionRepository.findPositionByName(name);
        return position.orElse(null);
    }
}
