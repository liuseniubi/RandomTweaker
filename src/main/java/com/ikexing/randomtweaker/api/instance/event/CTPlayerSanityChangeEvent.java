package com.ikexing.randomtweaker.api.instance.event;

import com.ikexing.randomtweaker.impl.events.SanityChangeEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.PlayerSanityChangeEvent")
public class CTPlayerSanityChangeEvent implements IEventCancelable {

    private final SanityChangeEvent event;

    public CTPlayerSanityChangeEvent(SanityChangeEvent event) {
        this.event = event;
    }

    @ZenGetter("player")
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getPlayer());
    }

    @ZenGetter("sanity")
    public float getSanity() {
        return event.getSanity();
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCanceled(canceled);
    }
}