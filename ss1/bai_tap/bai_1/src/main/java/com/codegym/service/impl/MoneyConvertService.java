package com.codegym.service.impl;

import com.codegym.service.IMoneyConvertService;
import org.springframework.stereotype.Service;

@Service
public class MoneyConvertService implements IMoneyConvertService {
    private static final double rate = 25000;
    @Override
    public double convertUsdToVnd(double usd) {
        return usd * rate;
    }
}
