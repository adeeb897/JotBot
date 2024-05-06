package com.jotbot.audio.device;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.jotbot.model.input.audio.AudioDevice;
import com.jotbot.model.input.audio.AudioStream;
import com.jotbot.model.input.audio.AudioStreamType;
import com.jotbot.model.input.audio.AudioStreamer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDeviceAudioStreamer implements AudioStreamer {

    private TargetDataLine audioLine;
    private AudioStreamType audioStreamType;

    public LocalDeviceAudioStreamer(LocalDeviceAudioStreamerInputs inputs, AudioStreamType audioStreamType) {
        this.audioStreamType = audioStreamType;
        log.info("Starting audio line for device: {}", inputs.getDevice().deviceName());
        this.audioLine = constructLineFromName(inputs.getDevice());
    }

    @Override
    public AudioStream startStream() {
        log.info("Starting audio stream");
        audioLine.start();
        return AudioStream.of(new AudioInputStream(audioLine), audioStreamType);
    }

    @Override
    public void killStream() {
        log.info("Stopping audio stream");
        audioLine.stop();
        audioLine.close();
    }

    private static TargetDataLine constructLineFromName(AudioDevice device) {
        TargetDataLine audioLine = null;
        try {
            // Connect to the default audio line
            // TODO: Implement device selection by name
            AudioFormat format = new AudioFormat(16000f, 16, 1, true, false);
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, format);
            audioLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            audioLine.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return audioLine;
    }
}