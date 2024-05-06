package com.jotbot.audio.device;

import com.jotbot.model.input.audio.AudioDevice;
import com.jotbot.model.input.audio.AudioStreamerInputs;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class LocalDeviceAudioStreamerInputs implements AudioStreamerInputs {
    @NonNull private final AudioDevice device;
}
