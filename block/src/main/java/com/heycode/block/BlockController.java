package com.heycode.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {

    private static final Logger logger = LoggerFactory.getLogger(BlockController.class);

    @GetMapping("/block/{second}")
    public void getBlock(@PathVariable Integer second) throws InterruptedException {
        Thread.sleep(second * 1000);

        logger.info("Blocked for {} seconds", second);
    }
}
