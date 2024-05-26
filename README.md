# ShieldDelay

ShieldDelay is a plugin that allows you to modify the cooldown delay between shield uses.

This plugin requires [Paper](https://papermc.io/software/paper) as it uses an event from the Paper API.

## Config
```yml
# the delay in ticks of a shield's cooldown
# a negative value will use the default cooldown
shield-delay: -1
```

## Commands
- `/shielddelay` - Shows information about the plugin.
- `/shielddelay reload` - Reloads the plugin's configuration.
- `/shielddelay set <delay>` - Sets the delay in ticks of a shield's cooldown.
- `/shielddelay get` - Shows the current delay in ticks of a shield's cooldown.

## Permissions
- `shielddelay.use` - Allows the use of the `/shielddelay` command.