package com.example.emotial;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.huawei.hms.mlsdk.face.MLFace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MLFaceGraphic extends GraphicOverlay.Graphic {
    private final GraphicOverlay overlay;
    private final Paint probilityPaint;
    private volatile MLFace mFace;

    public MLFaceGraphic(GraphicOverlay overlay, MLFace face) {
        super(overlay);

        mFace = face;
        this.overlay = overlay;

        probilityPaint = new Paint();
        probilityPaint.setColor(Color.BLACK);
        probilityPaint.setTextSize(45);
        probilityPaint.setTypeface(Typeface.DEFAULT);
    }

    public List<String> sortHashMap(HashMap<String, Float> map) {

        Set<Map.Entry<String, Float>> entey = map.entrySet();
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(entey);
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                if (o2.getValue() - o1.getValue() >= 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        List<String> emotions = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            emotions.add(list.get(i).getKey());
        }
        return emotions;
    }

    @Override
    public void draw(Canvas canvas) {
        if (mFace == null) {
            return;
        }
        float x = 350f;
        float y = overlay.getHeight() - 300.0f;
        HashMap<String, Float> emotions = new HashMap<>();
        emotions.put("Smiling", mFace.getEmotions().getSmilingProbability());
        emotions.put("Neutral", mFace.getEmotions().getNeutralProbability());
        emotions.put("Angry", mFace.getEmotions().getAngryProbability());
        emotions.put("Fear", mFace.getEmotions().getFearProbability());
        emotions.put("Sad", mFace.getEmotions().getSadProbability());
        emotions.put("Disgust", mFace.getEmotions().getDisgustProbability());
        emotions.put("Surprise", mFace.getEmotions().getSurpriseProbability());
        List<String> result = sortHashMap(emotions);

        // Draw the facial feature value.
        canvas.drawText(result.get(0), x, y, probilityPaint);
    }
}
