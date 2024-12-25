package com.campusseven.payment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebApiExRateProvider {

    BigDecimal getWebExRate(String currency) throws IOException {
        // 환율 가져오기  https://open.er-api.com/v6/latest/USD
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();
        //System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        //System.out.println(data);
        BigDecimal exRate = data.rates().get("KRW");
        //System.out.println(exRate);
        return exRate;
    }
}
