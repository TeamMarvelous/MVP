package com.marvelous.controller;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentenceSentiment;
import com.azure.core.credential.AzureKeyCredential;
import com.marvelous.text.AzureTextAnalyticsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    private static Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @GetMapping(path = "/test")
    public String index() {
        // TODO: Test Thread and remove
        String text = "I had the best day of my life. I wish you were there with me.";
        logger.info("text: " + text);

        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(AzureTextAnalyticsResource.AZURE_TEXT_ANALYTICS_API_KEY))
                .endpoint(AzureTextAnalyticsResource.AZURE_TEXT_ANALYTICS_ENDPOINT)
                .buildClient();

        DocumentSentiment documentSentiment = client.analyzeSentiment(text);
        System.out.printf(
                "Recognized document sentiment: %s, positive score: %s, neutral score: %s, negative score: %s.%n",
                documentSentiment.getSentiment(),
                documentSentiment.getConfidenceScores().getPositive(),
                documentSentiment.getConfidenceScores().getNeutral(),
                documentSentiment.getConfidenceScores().getNegative());
        System.out.println("Sentiment: " + documentSentiment.getSentiment());
        logger.debug("Positive: " + documentSentiment.getConfidenceScores().getPositive());
        logger.debug("Neutral: " + documentSentiment.getConfidenceScores().getNeutral());
        logger.debug("Negative: " + documentSentiment.getConfidenceScores().getNegative());

        for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
            logger.info("Sentiment: " + sentenceSentiment.getSentiment());
            logger.info("Positive: " + sentenceSentiment.getConfidenceScores().getPositive());
            logger.info("Neutral: " + sentenceSentiment.getConfidenceScores().getNeutral());
            logger.info("Negative: " + sentenceSentiment.getConfidenceScores().getNegative());
            logger.info("Text: " + sentenceSentiment.getText());
        }

        logger.info(documentSentiment.getSentences().toString());

        return "index";
    }

}
