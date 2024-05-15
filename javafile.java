import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zilliz.client.*;

import java.util.List;

@Service
public class EmbeddingService {

    private final ZillizClient zillizClient;

    @Autowired
    public EmbeddingService(ZillizClient zillizClient) {
        this.zillizClient = zillizClient;
    }

    public void processAndStoreEmbeddings(List<String> chunks) {
        // Generate embeddings using Hugging Face Transformers
        // Store embeddings in Zilliz
        for (String chunk : chunks) {
            float[] embedding = generateEmbedding(chunk);
            String id = RandomStringUtils.randomAlphanumeric(10);
            zillizClient.insert("document_embeddings", id, embedding, chunk);
        }
    }

    private float[] generateEmbedding(String text) {
        // Implement embedding generation logic here
        // For example, using Hugging Face's BERT model
        return new float[768];
    }
}
