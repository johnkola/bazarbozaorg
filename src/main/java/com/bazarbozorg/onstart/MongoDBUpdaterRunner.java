package com.bazarbozorg.onstart;

import com.bazarbozorg.logging.CustomLoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

//@Component
//@Order(1) // Ensures this runs before other startup tasks
public class MongoDBUpdaterRunner implements ApplicationRunner {


    private final MongoDBJSONUpdaterService jsonUpdaterService;
    Logger logger = CustomLoggerFactory.getLogger(MongoDBUpdaterRunner.class);


    public MongoDBUpdaterRunner(MongoDBJSONUpdaterService jsonUpdaterService) {
        this.jsonUpdaterService = jsonUpdaterService;
    }

    @Override
    public void run(ApplicationArguments args) {
        logger.info("🚀 Running MongoDB JSON Updater BEFORE web starts...");
        jsonUpdaterService.processJSONFiles();
        logger.info("✅ MongoDB JSON Updater Finished. Web application will now start.");
    }
}
