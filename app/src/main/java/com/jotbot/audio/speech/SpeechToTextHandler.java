package com.jotbot.audio.speech;

import javax.sound.sampled.AudioInputStream;

import com.jotbot.model.input.audio.AudioStream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpeechToTextHandler implements AudioHandler {

    @Override
    public void handleAudio(AudioStream audioStream) {
        AudioInputStream stream = audioStream.getAudioInputStream();
        // TODO: Implement speech to text
    }

}
