package com.jotbot.audio.speech;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import com.jotbot.model.input.audio.AudioStream;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AudioToFileHandler implements AudioHandler {

    @NonNull
    private String audioFilePath;

    @Override
    public void handleAudio(AudioStream audioStream) {
        AudioInputStream stream = audioStream.getAudioInputStream();
        File file = new File(this.audioFilePath);
        log.info("Writing audio to file: {}", file.getAbsolutePath());
        try {
            AudioSystem.write(stream, AudioFileFormat.Type.WAVE, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
