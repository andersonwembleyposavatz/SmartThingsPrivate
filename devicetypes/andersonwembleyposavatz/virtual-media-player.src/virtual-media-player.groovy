/**
 *  VIRTUAL Media Player
 *
 *  Copyright 2021 Anderson Wembley Posavatz
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
metadata {
	definition (name: "VIRTUAL Media Player", namespace: "andersonwembleyposavatz", author: "Anderson Wembley Posavatz", cstHandler: true) {
		capability "Audio Capture"
		capability "Audio Mute"
		capability "Audio Notification"
		capability "Audio Stream"
		capability "Audio Track Addressing"
		capability "Audio Track Data"
		capability "Audio Volume"
		capability "Camera Preset"
		capability "Execute"
		capability "Media Controller"
		capability "Media Group"
		capability "Media Input Source"
		capability "Media Playback"
		capability "Media Playback Repeat"
		capability "Media Playback Shuffle"
		capability "Media Presets"
		capability "Media Track Control"
		capability "Notification"
		capability "Remote Control Status"
		capability "Switch"
		capability "TV"
		capability "Tv Channel"
		capability "Video Camera"
		capability "Video Capture"
		capability "Video Stream"
		capability "Wifi Mesh Router"
		capability "webrtc"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'clip' attribute
	// TODO: handle 'stream' attribute
	// TODO: handle 'mute' attribute
	// TODO: handle 'uri' attribute
	// TODO: handle 'audioTrackData' attribute
	// TODO: handle 'totalTime' attribute
	// TODO: handle 'elapsedTime' attribute
	// TODO: handle 'volume' attribute
	// TODO: handle 'presets' attribute
	// TODO: handle 'data' attribute
	// TODO: handle 'activities' attribute
	// TODO: handle 'currentActivity' attribute
	// TODO: handle 'groupRole' attribute
	// TODO: handle 'groupPrimaryDeviceId' attribute
	// TODO: handle 'groupId' attribute
	// TODO: handle 'groupVolume' attribute
	// TODO: handle 'groupMute' attribute
	// TODO: handle 'inputSource' attribute
	// TODO: handle 'supportedInputSources' attribute
	// TODO: handle 'playbackStatus' attribute
	// TODO: handle 'supportedPlaybackCommands' attribute
	// TODO: handle 'playbackRepeatMode' attribute
	// TODO: handle 'playbackShuffle' attribute
	// TODO: handle 'presets' attribute
	// TODO: handle 'supportedTrackControlCommands' attribute
	// TODO: handle 'remoteControlEnabled' attribute
	// TODO: handle 'switch' attribute
	// TODO: handle 'volume' attribute
	// TODO: handle 'channel' attribute
	// TODO: handle 'power' attribute
	// TODO: handle 'picture' attribute
	// TODO: handle 'sound' attribute
	// TODO: handle 'movieMode' attribute
	// TODO: handle 'tvChannel' attribute
	// TODO: handle 'tvChannelName' attribute
	// TODO: handle 'camera' attribute
	// TODO: handle 'statusMessage' attribute
	// TODO: handle 'mute' attribute
	// TODO: handle 'settings' attribute
	// TODO: handle 'clip' attribute
	// TODO: handle 'stream' attribute
	// TODO: handle 'stream' attribute
	// TODO: handle 'wifiNetworkName' attribute
	// TODO: handle 'wifiGuestNetworkName' attribute
	// TODO: handle 'connectedRouterCount' attribute
	// TODO: handle 'disconnectedRouterCount' attribute
	// TODO: handle 'connectedDeviceCount' attribute
	// TODO: handle 'wifiNetworkStatus' attribute
	// TODO: handle 'wifiGuestNetworkStatus' attribute
	// TODO: handle 'sdpAnswer' attribute
	// TODO: handle 'talkback' attribute
	// TODO: handle 'supportedFeatures' attribute
	// TODO: handle 'audioOnly' attribute
	// TODO: handle 'stunUrl' attribute

}

// handle commands
def capture() {
	log.debug "Executing 'capture'"
	// TODO: handle 'capture' command
}

def setMute() {
	log.debug "Executing 'setMute'"
	// TODO: handle 'setMute' command
}

def mute() {
	log.debug "Executing 'mute'"
	// TODO: handle 'mute' command
}

def unmute() {
	log.debug "Executing 'unmute'"
	// TODO: handle 'unmute' command
}

def playTrack() {
	log.debug "Executing 'playTrack'"
	// TODO: handle 'playTrack' command
}

def playTrackAndResume() {
	log.debug "Executing 'playTrackAndResume'"
	// TODO: handle 'playTrackAndResume' command
}

def playTrackAndRestore() {
	log.debug "Executing 'playTrackAndRestore'"
	// TODO: handle 'playTrackAndRestore' command
}

def startAudio() {
	log.debug "Executing 'startAudio'"
	// TODO: handle 'startAudio' command
}

def stopAudio() {
	log.debug "Executing 'stopAudio'"
	// TODO: handle 'stopAudio' command
}

def setAudioTrack() {
	log.debug "Executing 'setAudioTrack'"
	// TODO: handle 'setAudioTrack' command
}

def setVolume() {
	log.debug "Executing 'setVolume'"
	// TODO: handle 'setVolume' command
}

def volumeUp() {
	log.debug "Executing 'volumeUp'"
	// TODO: handle 'volumeUp' command
}

def volumeDown() {
	log.debug "Executing 'volumeDown'"
	// TODO: handle 'volumeDown' command
}

def execute() {
	log.debug "Executing 'execute'"
	// TODO: handle 'execute' command
}

def create() {
	log.debug "Executing 'create'"
	// TODO: handle 'create' command
}

def delete() {
	log.debug "Executing 'delete'"
	// TODO: handle 'delete' command
}

def update() {
	log.debug "Executing 'update'"
	// TODO: handle 'update' command
}

def startActivity() {
	log.debug "Executing 'startActivity'"
	// TODO: handle 'startActivity' command
}

def setGroupVolume() {
	log.debug "Executing 'setGroupVolume'"
	// TODO: handle 'setGroupVolume' command
}

def groupVolumeUp() {
	log.debug "Executing 'groupVolumeUp'"
	// TODO: handle 'groupVolumeUp' command
}

def groupVolumeDown() {
	log.debug "Executing 'groupVolumeDown'"
	// TODO: handle 'groupVolumeDown' command
}

def setGroupMute() {
	log.debug "Executing 'setGroupMute'"
	// TODO: handle 'setGroupMute' command
}

def muteGroup() {
	log.debug "Executing 'muteGroup'"
	// TODO: handle 'muteGroup' command
}

def unmuteGroup() {
	log.debug "Executing 'unmuteGroup'"
	// TODO: handle 'unmuteGroup' command
}

def setInputSource() {
	log.debug "Executing 'setInputSource'"
	// TODO: handle 'setInputSource' command
}

def setPlaybackStatus() {
	log.debug "Executing 'setPlaybackStatus'"
	// TODO: handle 'setPlaybackStatus' command
}

def play() {
	log.debug "Executing 'play'"
	// TODO: handle 'play' command
}

def pause() {
	log.debug "Executing 'pause'"
	// TODO: handle 'pause' command
}

def stop() {
	log.debug "Executing 'stop'"
	// TODO: handle 'stop' command
}

def fastForward() {
	log.debug "Executing 'fastForward'"
	// TODO: handle 'fastForward' command
}

def rewind() {
	log.debug "Executing 'rewind'"
	// TODO: handle 'rewind' command
}

def setPlaybackRepeatMode() {
	log.debug "Executing 'setPlaybackRepeatMode'"
	// TODO: handle 'setPlaybackRepeatMode' command
}

def setPlaybackShuffle() {
	log.debug "Executing 'setPlaybackShuffle'"
	// TODO: handle 'setPlaybackShuffle' command
}

def playPreset() {
	log.debug "Executing 'playPreset'"
	// TODO: handle 'playPreset' command
}

def nextTrack() {
	log.debug "Executing 'nextTrack'"
	// TODO: handle 'nextTrack' command
}

def previousTrack() {
	log.debug "Executing 'previousTrack'"
	// TODO: handle 'previousTrack' command
}

def deviceNotification() {
	log.debug "Executing 'deviceNotification'"
	// TODO: handle 'deviceNotification' command
}

def on() {
	log.debug "Executing 'on'"
	// TODO: handle 'on' command
}

def off() {
	log.debug "Executing 'off'"
	// TODO: handle 'off' command
}

def channelUp() {
	log.debug "Executing 'channelUp'"
	// TODO: handle 'channelUp' command
}

def setTvChannel() {
	log.debug "Executing 'setTvChannel'"
	// TODO: handle 'setTvChannel' command
}

def channelDown() {
	log.debug "Executing 'channelDown'"
	// TODO: handle 'channelDown' command
}

def setTvChannelName() {
	log.debug "Executing 'setTvChannelName'"
	// TODO: handle 'setTvChannelName' command
}

def flip() {
	log.debug "Executing 'flip'"
	// TODO: handle 'flip' command
}

def stopStream() {
	log.debug "Executing 'stopStream'"
	// TODO: handle 'stopStream' command
}

def enableWifiNetwork() {
	log.debug "Executing 'enableWifiNetwork'"
	// TODO: handle 'enableWifiNetwork' command
}

def disableWifiNetwork() {
	log.debug "Executing 'disableWifiNetwork'"
	// TODO: handle 'disableWifiNetwork' command
}

def enableWifiGuestNetwork() {
	log.debug "Executing 'enableWifiGuestNetwork'"
	// TODO: handle 'enableWifiGuestNetwork' command
}

def disableWifiGuestNetwork() {
	log.debug "Executing 'disableWifiGuestNetwork'"
	// TODO: handle 'disableWifiGuestNetwork' command
}

def sdpOffer() {
	log.debug "Executing 'sdpOffer'"
	// TODO: handle 'sdpOffer' command
}

def end() {
	log.debug "Executing 'end'"
	// TODO: handle 'end' command
}