package org.amethystdev.testplugin.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.CommandPlaceholder;
import revxrsal.commands.annotation.Description;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

@Command({"TestCommand","Test"})
public class TestCommand {

    @CommandPlaceholder
    @Description("This is a command placeholder that is run when /Test is executed")
    public void onTest(BukkitCommandActor actor) {
        actor.reply("Hello world!");
    }

    @Subcommand("meow")
    public void meow(BukkitCommandActor actor) {
        actor.reply(Component.text("Meow").color(TextColor.color(159, 43, 104)));
    }
}
