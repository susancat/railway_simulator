# railway_simulator
railway-simulator
A Java program for railway simulator. It allows trains to move through segments of track and stations. 
Features: 
• Segments of track can only have one train in them at a time 
• Stations can have multiple trains in them at a time 
• The train company has two types of trains: express (fast) and local (slow) 
• Each track segment / station has a length: l. This should be in metres. A typical segment might be 1,000 m long. A station 100m. 
• Each train has a speed: s. Fast trains travel at 500 metres per second (wow!). Slow ones at a mere 10 metres per second. 
• The time a train is in any segment is l/s 
• The time a train is in a staion is l/s + 5 (they stop for 5 seconds – people have to get on and off quickly!) 
• When the time is up (i.e. the train is at the end of the segment or has finished in a station), it can only move into the next segment if there is space. Space is determined by capacity. I.e. a station with capacity 3 can have 3 trains in it at once. Segments can only have one train in them at once.
