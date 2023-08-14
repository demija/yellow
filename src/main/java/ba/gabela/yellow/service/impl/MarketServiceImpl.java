package ba.gabela.yellow.service.impl;

import ba.gabela.yellow.database.model.Market.Redis.MarketRedis;
import ba.gabela.yellow.database.repository.MarketRedisRepository;
import ba.gabela.yellow.generated.model.Market;
import ba.gabela.yellow.service.MarketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketRedisRepository marketRedisRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Market> getAll() {
        List<MarketRedis> list = StreamSupport.stream(marketRedisRepository.findAll().spliterator(), false)
                .toList();

        return list.stream()
                .map(item -> modelMapper.map(item, Market.class))
                .collect(Collectors.toList());
    }
}
