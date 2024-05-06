package com.jotbot.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.jotbot.audio.device.LocalDeviceAudioStreamer;
import com.jotbot.audio.device.LocalDeviceAudioStreamerInputs;
import com.jotbot.audio.speech.AudioHandler;
import com.jotbot.audio.speech.AudioToFileHandler;
import com.jotbot.model.input.audio.AudioDevice;
import com.jotbot.model.input.audio.AudioStreamType;

public class AudioStreamerModule extends AbstractModule {

    @Provides
    public AudioDevice speakerName() {
        return new AudioDevice("WH-CH700N");
    }

    @Provides
    public String audioFilePath() {
        return "test.wav";
    }

    @Provides
    @Named(ModuleConstants.MICROPHONE)
    public LocalDeviceAudioStreamer microphoneAudioStreamer(AudioDevice microphone) {
        return new LocalDeviceAudioStreamer(LocalDeviceAudioStreamerInputs.builder()
                .device(microphone)
                .build(), AudioStreamType.MICROPHONE);
    }

    @Provides
    public AudioHandler audioHandler(String filePath) {
        return new AudioToFileHandler(filePath);
    }

}
