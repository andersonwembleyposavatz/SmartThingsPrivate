/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "VIRTUAL Water Valve", namespace: "smartthings", author: "SmartThings", ocfDeviceType: "oic.d.watervalve", runLocally: true, minHubCoreVersion: '000.017.0012', executeCommandsLocally: false) {
		capability "Actuator"
		capability "Health Check"
		capability "Valve"
		capability "Refresh"
		capability "Sensor"

	}

	// simulator metadata
	simulator {
	}

	// tile definitions
	tiles(scale: 2) {
		multiAttributeTile(name:"valve", type: "generic", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.valve", key: "PRIMARY_CONTROL") {
				attributeState "open", label: '${name}', action: "valve.close", icon: "st.valves.water.open", backgroundColor: "#00A0DC", nextState:"closing"
				attributeState "closed", label: '${name}', action: "valve.open", icon: "st.valves.water.closed", backgroundColor: "#ffffff", nextState:"opening"
				attributeState "opening", label: '${name}', action: "valve.close", icon: "st.valves.water.open", backgroundColor: "#00A0DC"
				attributeState "closing", label: '${name}', action: "valve.open", icon: "st.valves.water.closed", backgroundColor: "#ffffff"
			}
				}
		standardTile("open", "device.valve", inactiveLabel: false, decoration: "flat") {
			state "default", label:'open', action:"open", icon:"st.valves.water.open"
		}
		standardTile("close", "device.valve", inactiveLabel: false, decoration: "flat") {
			state "default", label:'close', action:"close", icon:"st.valves.water.closed"
		
		}

		main "toggle"
		details(["toggle", "open", "close", "on", "off"])
	}
}

def parse(description) {
	
}

def open() {
	sendEvent(name: "valve", value: "opening")
    runIn(3, finishOpening)
}

def close() {
    sendEvent(name: "valve", value: "closing")
	runIn(3, finishClosing)
}

def on() {
	sendEvent(name: "valve", value: "opening")
    runIn(3, finishOpening)
}

def off() {
    sendEvent(name: "valve", value: "closing")
	runIn(3, finishClosing)
}

def finishOpening() {
    sendEvent(name: "valve", value: "open")
    sendEvent(name: "contact", value: "open")
}

def finishClosing() {
    sendEvent(name: "valve", value: "closed")
    sendEvent(name: "contact", value: "closed")
    }

def installed() {
	initialize()
}

def updated() {
	initialize()
}

def initialize() {
    sendEvent(name: "valve", value: "closed")
    sendEvent(name: "contact", value: "closed")

	sendEvent(name: "DeviceWatch-DeviceStatus", value: "online")
	sendEvent(name: "healthStatus", value: "online")
	sendEvent(name: "DeviceWatch-Enroll", value: [protocol: "cloud", scheme:"untracked"].encodeAsJson(), displayed: false)
}