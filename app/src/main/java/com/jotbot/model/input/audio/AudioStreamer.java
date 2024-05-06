package com.jotbot.model.input.audio;

public interface AudioStreamer {
    AudioStream startStream();
    void killStream();
}
