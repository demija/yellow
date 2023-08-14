package ba.gabela.yellow.controller;

import ba.gabela.yellow.generated.api.MarketApi;
import ba.gabela.yellow.generated.model.Market;
import ba.gabela.yellow.service.impl.MarketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketController implements MarketApi {
    @Autowired
    private MarketServiceImpl marketService;

    @Override
    public ResponseEntity<List<Market>> getMarketList() {
        return ResponseEntity.ok(marketService.getAll());
    }
}
