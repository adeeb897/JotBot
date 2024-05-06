package com.jotbot.model.input.audio;

import javax.sound.sampled.AudioInputStream;

import com.jotbot.model.input.InputStream;
import com.jotbot.model.input.StreamType;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class AudioStream implements InputStream {

    @NonNull
    private AudioInputStream audioInputStream;
    @NonNull
    private AudioStreamType audioStreamType;

    private AudioStream(AudioInputStream audioInputStream, AudioStreamType audioStreamType) {
        this.audioInputStream = audioInputStream;
        this.audioStreamType = audioStreamType;
    }

    public static AudioStream of(AudioInputStream audioInputStream, AudioStreamType audioStreamType) {
        return new AudioStream(audioInputStream, audioStreamType);
    }

    @Override
    public StreamType getStreamType() {
        return StreamType.AUDIO;
    }
}
