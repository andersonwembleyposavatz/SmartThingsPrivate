/**
 *
 *	Copyright 2019 SmartThings
 *
 *	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *	in compliance with the License. You may obtain a copy of the License at:
 *
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *	on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *	for the specific language governing permissions and limitations under the License.
 */
metadata {
	definition (name: "VIRTUAL Windows Shade Beautiful", namespace: "andersonwembleyposavatz", author: "Anderson W Posavatz", runLocally: true , executeCommandsLocally: true , ocfDeviceType: "oic.d.blind", mnmn: "SmartThings", vid: "generic-shade-2") {
		capability "Actuator"
		capability "Contact Sensor"
		capability "Switch"
		capability "Sensor"
		capability "Health Check"
		capability "Window Shade"
		capability "Window Shade Preset"
		//capability "Switch Level"

		command "openPartially"
		command "closePartially"
		command "partiallyOpen"
		command "opening"
		command "closing"
		command "opened"
		command "closed"
		command "unknown"
	}

	preferences {
		section {
			input("actionDelay", "number",
				title: "Action Delay\n\nAn emulation for how long it takes the window shade to perform the requested action.",
				description: "In seconds (1-120; default if empty: 5 sec)",
				range: "1..120", displayDuringSetup: true)
		}
		section {
			input("supportedCommands", "enum",
				title: "Supported Commands\n\nThis controls the value for supportedWindowShadeCommands.",
				description: "open, close, pause", defaultValue: "2", multiple: false,
				options: [
					"1": "open, close",
					"2": "open, close, pause",
					"3": "open",
					"4": "close",
					"5": "pause",
					"6": "open, pause",
					"7": "close, pause",
				]
			)
		}
	}

    tiles(scale: 2) {
        multiAttributeTile(name: "windowShade", type: "generic", width: 6, height: 4) {
            tileAttribute("device.windowShade", key: "PRIMARY_CONTROL") {
                attributeState "open",  label:'${name}', action: "close", icon: "http://www.ezex.co.kr/img/st/window_open.png", backgroundColor: "#79b821", nextState: "closing"
                attributeState "closed", label:'${name}', action: "open", icon: "http://www.ezex.co.kr/img/st/window_close.png", backgroundColor: "#ffffff", nextState: "opening"
   				attributeState "partially open", label:'Open', action:"close", icon:"st.shades.shade-open", backgroundColor:"#79b821", nextState:"closing"
                attributeState "opening",  label:'${name}', action: "close", icon: "http://www.ezex.co.kr/img/st/window_open.png", backgroundColor: "#79b821", nextState: "closing"
                attributeState "closing",  label:'${name}', action: "open", icon: "http://www.ezex.co.kr/img/st/window_close.png", backgroundColor: "#ffffff", nextState: "opening"
			}
			/*tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"setLevel"
			}*/
            
		}
		standardTile("Open", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "Open", action:"open", icon:"http://www.ezex.co.kr/img/st/window_open.png"
		}
		standardTile("Close", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "Close", action:"close", icon:"http://www.ezex.co.kr/img/st/window_close.png"
		}

		standardTile("windowShadeOpen", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "open", action:"open", icon:"st.Home.home2"
		}
		standardTile("windowShadeClose", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "close", action:"close", icon:"st.Home.home2"
		}
		standardTile("windowShadePause", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "pause", action:"pause", icon:"st.Home.home2"
		}
		standardTile("windowShadePreset", "device.windowShadePreset", width: 2, height: 2, decoration: "flat") {
			state "default", label: "preset", action:"presetPosition", icon:"st.Home.home2"
		}

		valueTile("statesLabel", "device.states", width: 6, height: 1, decoration: "flat") {
			state "default", label: "State Events:"	
		}

		standardTile("windowShadePartiallyOpen", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "partially open", action:"partiallyOpen", icon:"st.Home.home2"
		}
		standardTile("windowShadeOpening", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "opening", action:"opening", icon:"st.Home.home2"
		}
		standardTile("windowShadeClosing", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "closing", action:"closing", icon:"st.Home.home2"
		}
		standardTile("windowShadeOpened", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "opened", action:"opened", icon:"st.Home.home2"
		}
		standardTile("windowShadeClosed", "device.windowShade", width: 2, height: 2, decoration: "flat") {
			state "default", label: "closed", action:"closed", icon:"st.Home.home2"
		
		}
        
		main(["windowShade"])
		details(["windowShade",
				 "commandsLabel",
				 "windowShadeOpen", "windowShadeClose", "windowShadePause", "windowShadePreset", "blank",
				 "statesLabel",
				 "windowShadePartiallyOpen", "windowShadeOpening", "windowShadeClosing", "windowShadeOpened", "windowShadeClosed", "windowShadeUnknown"])
                 }
}
private getSupportedCommandsMap() {
	[
		"1": ["open", "close"],
		"2": ["open", "close", "pause"],
		"3": ["open"],
		"4": ["close"],
		"5": ["pause"],
		"6": ["open", "pause"],
		"7": ["close", "pause"],
		"8": [],
		"9": ["open", "closed", "pause"],
		"10": ["open", "closed", "close", "pause"]
	]
}

private getShadeActionDelay() {
	(settings.actionDelay != null) ? settings.actionDelay : 5
}

def installed() {
	log.debug "installed()"

	updated()
	opened()
}

def updated() {
	log.debug "updated()"

	def commands = (settings.supportedCommands != null) ? settings.supportedCommands : "9"

	sendEvent(name: "supportedWindowShadeCommands", value: JsonOutput.toJson(supportedCommandsMap[commands]))

}

private initialize() {
	log.trace "Executing 'initialize'"

	sendEvent(name: "DeviceWatch-DeviceStatus", value: "online")
	sendEvent(name: "healthStatus", value: "online")
	sendEvent(name: "DeviceWatch-Enroll", value: [protocol: "cloud", scheme:"untracked"].encodeAsJson(), displayed: false)
}


def parse(String description) {
	log.trace "parse($description)"
}

// Capability commands

// TODO: Implement a state machine to fine tune the behavior here.
// Right now, tapping "open" and then "pause" leads to "opening",
// "partially open", then "open" as the open() command completes.
// The `runIn()`s below should all call a marshaller to handle the
// movement to a new state. This will allow for shade level sim, too.

def open() {
	log.debug "open()"
	opening()
	runIn(shadeActionDelay, "opened")
}

def close() {
	log.debug "close()"
	closing()
	runIn(shadeActionDelay, "closed")
}

def pause() {
	log.debug "pause()"
	partiallyOpen()
}

def presetPosition() {
	log.debug "presetPosition()"
	if (device.currentValue("windowShade") == "open") {
		closePartially()
	} else if (device.currentValue("windowShade") == "closed") {
		openPartially()
	} else {
		partiallyOpen()
	}
}

// Custom test commands

def openPartially() {
	log.debug "openPartially()"
	opening()
	runIn(shadeActionDelay, "partiallyOpen")
}

def closePartially() {
	log.debug "closePartially()"
	closing()
	runIn(shadeActionDelay, "partiallyOpen")
}

def partiallyOpen() {
	log.debug "windowShade: partially open"
	sendEvent(name: "windowShade", value: "partially open", isStateChange: true)
}

def opening() {
	log.debug "windowShade: opening"
	sendEvent(name: "windowShade", value: "opening", isStateChange: true)
}

def closing() {
	log.debug "windowShade: closing"
	sendEvent(name: "windowShade", value: "closing", isStateChange: true)
}

def opened() {
	sendEvent(name: "windowShade", value: "opened", isStateChange: true)
	sendEvent(name: "contact", value: "open", isStateChange: true)
}

def closed() {
	sendEvent(name: "windowShade", value: "closed", isStateChange: true)
	sendEvent(name: "contact", value: "closed", isStateChange: true)
}