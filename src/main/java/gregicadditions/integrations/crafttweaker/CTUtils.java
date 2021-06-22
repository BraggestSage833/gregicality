package gregicadditions.integrations.crafttweaker;

import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gregicadditions.item.GAOredictItem;
import gregicadditions.materials.SimpleDustMaterial;
import gregicadditions.materials.SimpleFluidMaterial;
import gregicadditions.utils.GALog;
import gregicadditions.worldgen.PumpjackHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import gregtech.api.unification.material.type.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import gregicadditions.GAValues;
import gregtech.common.pipelike.cable.WireProperties;


import java.util.List;
import java.util.stream.Collectors;

import static gregicadditions.GAMaterials.addCableAboveGTCELimit;
import static gregicadditions.GAMaterials.ignoreCable;
import static gregicadditions.GAUtility.getTierByVoltage;


@ZenClass("mods.gtadditions.recipe.Utils")
@ZenRegister
public class CTUtils {


    @ZenMethod("removeRecipeByOutput")
    public static void removeRecipeByOutput(RecipeMap<?> recipeMap, IItemStack[] outputs, ILiquidStack[] fluidOutputs, boolean useAmounts) {
        List<Recipe> recipesToRemove = new ArrayList<>();
        List<ItemStack> mcItemOutputs = outputs == null ? Collections.emptyList() :
                Arrays.stream(outputs)
                        .map(CraftTweakerMC::getItemStack)
                        .collect(Collectors.toList());

        List<FluidStack> mcFluidOutputs = fluidOutputs == null ? Collections.emptyList() :
                Arrays.stream(fluidOutputs)
                        .map(CraftTweakerMC::getLiquidStack)
                        .collect(Collectors.toList());

        for (Object recipe : recipeMap.getRecipeList()) {
            if (recipe instanceof Recipe) {
                if (!mcItemOutputs.isEmpty()) {
                    for (ItemStack output : ((Recipe) recipe).getOutputs()) {
                        for (ItemStack itemStack : mcItemOutputs) {
                            if (output.isItemEqual(itemStack) && output.getMetadata() == itemStack.getMetadata()) {
                                if (useAmounts) {
                                    if (output.getCount() == itemStack.getCount()) {
                                        recipesToRemove.add((Recipe) recipe);
                                        GALog.logger.info(output.getDisplayName());
                                    }
                                } else {
                                    recipesToRemove.add((Recipe) recipe);
                                    GALog.logger.info(output.getDisplayName());
                                }
                            }
                        }
                    }
                }
                if (!mcFluidOutputs.isEmpty()) {
                    for (FluidStack fluidOutput : ((Recipe) recipe).getFluidOutputs()) {
                        for (FluidStack fluidStack : mcFluidOutputs) {
                            if (fluidOutput.isFluidEqual(fluidStack)) {
                                if (useAmounts) {
                                    if (fluidOutput.amount == fluidStack.amount) {
                                        recipesToRemove.add((Recipe) recipe);
                                    }
                                } else {
                                    recipesToRemove.add((Recipe) recipe);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Recipe recipe : recipesToRemove) {
            recipeMap.removeRecipe(recipe);
        }
    }

    @ZenMethod("registerDust")
    public static void registerDust(String name, short id, int rgb, String materialIconSet) {
        new SimpleDustMaterial(name, rgb, id, MaterialIconSet.valueOf(materialIconSet));
    }

    @ZenMethod("registerItem")
    public static void registerItem(String name, short id, int rgb, String materialIconSet, String orePrefix) {
        new GAOredictItem.OreDictItem(id, name, rgb, MaterialIconSet.valueOf(materialIconSet), OrePrefix.valueOf(orePrefix));
    }

    @ZenMethod("registerFluid")
    public static void registerFluid(String name, int rgb, @Optional String tooltip) {
        new SimpleFluidMaterial(name, rgb, tooltip);
    }

    @ZenMethod
    public static void registerReservoir(ILiquidStack fluid, int minSize, int maxSize, int replenishRate, int weight, int[] dimBlacklist, int[] dimWhitelist, String[] biomeBlacklist, String[] biomeWhitelist) {
        List<Integer> biomeBlacklistList = Lists.newArrayList();
        List<Integer> biomeWhitelistList = Lists.newArrayList();

        if (minSize <= 0) {
            CraftTweakerAPI.logError("Reservoir minSize has to be at least 1mb!");
        } else if (maxSize < minSize) {
            CraftTweakerAPI.logError("Reservoir maxSize can not be smaller than minSize!");
        } else if (weight <= 1) {
            CraftTweakerAPI.logError("Reservoir weight has to be greater than or equal to 1!");
        }

        String rFluid = fluid.getName();

        PumpjackHandler.ReservoirType res = PumpjackHandler.addReservoir(rFluid, minSize, maxSize, replenishRate, weight);

        for (String black : biomeBlacklist) {
            if (black == null || black.isEmpty()) {
                CraftTweakerAPI.logError("String '" + black + "' in biomeBlacklist is either Empty or Null");
            } else {
                biomeBlacklistList.add(Integer.valueOf(black));
            }
        }

        for (String white : biomeWhitelist) {
            if (white == null || white.isEmpty()) {
                CraftTweakerAPI.logError("String '" + white + "' in biomeBlacklist is either Empty or Null");
            } else {
                biomeWhitelistList.add(Integer.valueOf(white));
            }
        }

        res.dimensionBlacklist = Arrays.stream(dimBlacklist).boxed().collect(Collectors.toList());
        res.dimensionWhitelist = Arrays.stream(dimWhitelist).boxed().collect(Collectors.toList());
        res.biomeBlacklist = biomeBlacklistList;
        res.biomeWhitelist = biomeWhitelistList;

        CraftTweakerAPI.logInfo("Added Reservoir Type: " + rFluid);
    }
    //TODO
    //figure out what method fixes the tooltips
    @ZenMethod("AboveGTCELimit")
    public static void AboveGTCELimit(Material m, long voltage, int amperage, int lossPerBlock) {
        String volt = String.valueOf(getTierByVoltage(voltage));
        if (m instanceof IngotMaterial) {
        switch(volt) {
            case("9"):
                ((IngotMaterial) m).setCableProperties(GAValues.V[GAValues.UHV],amperage,lossPerBlock);
                ignoreCable((IngotMaterial) m);
                addCableAboveGTCELimit((IngotMaterial) m, new WireProperties(GAValues.V[GAValues.UHV],amperage,lossPerBlock));

            break;
            case("10"):
                ((IngotMaterial) m).setCableProperties(GAValues.V[GAValues.UEV],amperage,lossPerBlock);
                ignoreCable((IngotMaterial) m);
                addCableAboveGTCELimit((IngotMaterial) m, new WireProperties(GAValues.V[GAValues.UEV],amperage,lossPerBlock));
                break;
            case("11"):
                ((IngotMaterial) m).setCableProperties(GAValues.V[GAValues.UIV],amperage,lossPerBlock);
                ignoreCable((IngotMaterial) m);
                addCableAboveGTCELimit((IngotMaterial) m, new WireProperties(GAValues.V[GAValues.UIV],amperage,lossPerBlock));
                break;
            case("12"):
                ((IngotMaterial) m).setCableProperties(GAValues.V[GAValues.UMV],amperage,lossPerBlock);
                ignoreCable((IngotMaterial) m);
                addCableAboveGTCELimit((IngotMaterial) m, new WireProperties(GAValues.V[GAValues.UMV],amperage,lossPerBlock));
                break;
            case("13"):
                ((IngotMaterial) m).setCableProperties(GAValues.V[GAValues.UXV],amperage,lossPerBlock);
                ignoreCable((IngotMaterial) m);
                addCableAboveGTCELimit((IngotMaterial) m, new WireProperties(GAValues.V[GAValues.UXV],amperage,lossPerBlock));
                break;
            case("14"):
                ((IngotMaterial) m).setCableProperties(GAValues.V[GAValues.MAX],amperage,lossPerBlock);
                ignoreCable(m);
                addCableAboveGTCELimit((IngotMaterial) m, new WireProperties(GAValues.V[GAValues.MAX],amperage,lossPerBlock));
                break;
            default:
                CraftTweakerAPI.logError("long '" + voltage + "' voltage does not match");
        }
        }

    }
}
