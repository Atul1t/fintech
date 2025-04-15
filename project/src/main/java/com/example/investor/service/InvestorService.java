package com.example.investor.service;

import com.example.investor.entity.Investor;
import com.example.investor.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah", "Ian", "Jack"};
    private static final String[] STOCKS = {"AAPL", "GOOGL", "AMZN", "MSFT", "TSLA", "META"};

    public void generateDummyInvestors() {
        Random random = new Random();
        List<Investor> investors = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Investor inv = new Investor();
            String name = NAMES[random.nextInt(NAMES.length)];
            inv.setName(name);
            inv.setEmail(name.toLowerCase() + i + "@example.com");
            inv.setStockname(STOCKS[random.nextInt(STOCKS.length)]);
            inv.setInvestmentAmount(1000 + (5000 - 1000) * random.nextDouble());
            inv.setInvestmentDate(LocalDate.now().minusDays(random.nextInt(365)));
            investors.add(inv);
        }

        investorRepository.saveAll(investors);
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public List<Investor> searchInvestorsByName(String name) {
        return investorRepository.findByNameContainingIgnoreCase(name);
    }
}
