# AntiFreecam

AntiFreecam is a Minecraft Fabric Mod that runs on both server and client.

It exists to force collisions when the client uses the Freecam Mod, no matter what users have their settings set to.

## Usage

Just install it on the Server and restart.

From now on, all players\* that want to join, are required to have AntiFreecam installed on their client too.

Once a player joins, the server automatically notifies the client to always enable collisions. The players
configurations are simply ignored.

*\*All players: even the ones that doesn't even have Freecam installed. Because a server cant detect whether a player
has a mod installed, that doesn't communicate with the server (like Freecam does).*

## Upcoming Features

These are some features I plan to do in the future™.

- Easy reloadable server config file.  
  With a `/antifreecam reload` command or something.  
  Maybe even with ingame editable config
- Instead of disabling all collisions, let the server (config) decide what collisions are allowed.
- Prevent the use of Freecam altogether.  
  Don't even allow a player to hop into Freecam, like they haven't installed it.
- ...
- Merge the client code in the Freecam mod.  
  At some point I want this to be adopted by Freecam.
