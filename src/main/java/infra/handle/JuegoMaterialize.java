package infra.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JuegoMaterialize {

    private static final String COLLECTION_NAME = "juegos";
    private static final Logger logger = Logger.getLogger(JuegoMaterialize.class.getName());

    @Autowired
    @Qualifier("mongoTemplateQueries")
    private MongoTemplate mongoTemplate;
}
