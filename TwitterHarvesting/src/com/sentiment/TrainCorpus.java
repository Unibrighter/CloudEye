package com.sentiment;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.classify.LMClassifier;
import com.aliasi.corpus.ObjectHandler;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.Compilable;
import com.aliasi.util.Files;
import com.file.FileUtils;

public class TrainCorpus {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void train() throws IOException, ClassNotFoundException {
        File trainDir;
        String[] categories;
        LMClassifier classify;
        trainDir = new File("trainDirectory");
        categories = trainDir.list();
        String[] mCategories = {};

        int nGram = 7; // the nGram level, any value between 7 and 12 works
        classify = DynamicLMClassifier.createNGramProcess(mCategories, nGram);
        for (int i = 0; i < categories.length; ++i) {
            String category = categories[i];
            Classification classification = new Classification(category);
            File file = new File(trainDir, categories[i]);
            File[] trainFiles = file.listFiles();
            for (int j = 0; j < trainFiles.length; ++j) {
                File trainFile = trainFiles[j];
                String review = Files.readFromFile(trainFile,
                        FileUtils.FILE_FORMAT);
                Classified classified = new Classified(review, classification);
                ((ObjectHandler) classify).handle(classified);
            }
        }

        // This classifier file should be trained before importing into the
        // project.
        AbstractExternalizable
                .compileTo((Compilable) classify,
                        new File(SentimentClassifier.class
                                .getResource(FileUtils.FILE_CLASSIFIER)
                                .getPath()));
    }
}
