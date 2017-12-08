#include <ESP8266WiFi.h>
#include <WiFiUdp.h>
#include <IPAddress.h>

const char* ssid = "******";
const char* password = "*******";

IPAddress serverIP(000,000,0,00);
const int serverPort = 4445;

WiFiUDP Udp;
unsigned int localUdpPort = 4210;  // local port to listen on
char incomingPacket[255];  // buffer for incoming packets
char  dataPacket[8];  // output buffer


void setup()
{
  Serial.begin(9600);
  Serial.println();

  Serial.printf("Connecting to %s ", ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println(" connected");

  Udp.begin(localUdpPort);
  Serial.printf("Now listening at IP %s, UDP port %d\n", WiFi.localIP().toString().c_str(), localUdpPort);
}


void loop()
{
    String sensorValue = (String)analogRead(A0);                  //Read pin value and set to sensorValue
    strncpy(dataPacket, sensorValue.c_str(),sizeof(sensorValue)); //Set putput buffer to pin value
    Serial.println(dataPacket);

  //Send test packet using global serverIP/serverPort
    Udp.beginPacket(serverIP, serverPort);
    Udp.write(dataPacket);
    Udp.endPacket();

    int packetSize = Udp.parsePacket();
  if (packetSize)
  {
    // receive incoming UDP packets
    Serial.printf("Received %d bytes from %s, port %d\n", packetSize, Udp.remoteIP().toString().c_str(), Udp.remotePort());
    int len = Udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    Serial.printf("UDP packet contents: %s\n", incomingPacket);
  }
  delay(600000); //Wait 10 minutes before sending new dataPacket
}
