package com.kakaopaysec.casecloudconfigclient.config.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/config")
@Slf4j
@RefreshScope
@RestController
public class ConfigApi {

    @Value("${fund.channel.service.url}")
    private String fundChannelUrl;

    @Value("${genie.javis.service.url}")
    private String genieUrl;

    @Value("${money.platform.service.url}")
    private String moneyPlatformUrl;

    @Value("${kafka.ums.service.url}")
    private String umsUrl;

    @Value("${kafka.ums.service.topic}")
    private String umsTopic;

    @GetMapping("/funds")
    public String getFundChannelUrl() {
        log.info("fundChannelUrl: [{}]", fundChannelUrl);
        return fundChannelUrl;
    }

    @GetMapping("/accounts")
    public String getGenielUrl() {
        log.info("GenieUrl: [{}]", genieUrl);
        return genieUrl;
    }

    @GetMapping("/banks")
    public String getMoneyPlatformUrl() {
        log.info("moneyPlatformUrl: [{}]", moneyPlatformUrl);
        return moneyPlatformUrl;
    }

    @GetMapping("/common")
    public String getKafkaUmsInfo() {
        log.info("kafka url: [{}]", umsUrl);
        log.info("kafka topic: [{}]", umsTopic);

        StringBuilder builder = new StringBuilder();
        builder.append("UMS URL: " + umsUrl + "\n");
        builder.append("UMS TOPIC: " + umsTopic);
        return builder.toString();
    }
}
