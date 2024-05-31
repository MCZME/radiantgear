/*
 * Copyright (C) 2022 Illusive Soulworks
 *
 * Radiant Gear is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Radiant Gear is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Radiant Gear.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.illusivesoulworks.radiantgear;

import com.illusivesoulworks.radiantgear.integration.arsnouveau.ArsNouveauModule;
import com.illusivesoulworks.radiantgear.integration.dynamiclights.DynamicLightsModule;
import com.illusivesoulworks.radiantgear.integration.dynamiclightsreforged.DLReforgedModule;
import com.illusivesoulworks.radiantgear.integration.ryoamiclights.RyoamicModule;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(RadiantGearConstants.MOD_ID)
public class RadiantGearNeoForgeMod {

  private static boolean isDynamicLightsLoaded = false;
  private static boolean isDLReforgedLoaded = false;
  private static boolean isArsNouveauLoaded = false;
  private static boolean isRyoamicLoaded = false;

  public RadiantGearNeoForgeMod(IEventBus eventBus) {
    ModList modList = ModList.get();
    isDynamicLightsLoaded = modList.isLoaded("dynamiclights");
    isDLReforgedLoaded = modList.isLoaded("dynamiclightsreforged");
    isArsNouveauLoaded = modList.isLoaded("ars_nouveau");
    isRyoamicLoaded = modList.isLoaded("ryoamiclights");
    eventBus.addListener(this::setup);
    eventBus.addListener(this::clientSetup);
  }

  private void setup(final FMLCommonSetupEvent evt) {

    if (isDynamicLightsLoaded) {
      DynamicLightsModule.setup();
    }
  }

  private void clientSetup(final FMLClientSetupEvent evt) {

    if (isDLReforgedLoaded) {
      DLReforgedModule.setup();
    }

    if (isRyoamicLoaded) {
      RyoamicModule.setup();
    }

    if (isArsNouveauLoaded) {
      ArsNouveauModule.setup();
    }
  }
}