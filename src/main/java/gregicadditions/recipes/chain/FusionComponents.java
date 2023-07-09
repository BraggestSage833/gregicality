package gregicadditions.recipes.chain;

import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.fusion.GACryostatCasing;
import gregicadditions.item.fusion.GADivertorCasing;
import gregicadditions.item.fusion.GAFusionCasing;
import gregicadditions.item.fusion.GAVacuumCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;

import static gregicadditions.GAMaterials.*;
import static gregicadditions.item.GAMetaItems.*;
import static gregicadditions.recipes.GARecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class FusionComponents {
    public static void init() {

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1000).EUt(500000)
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_1))
                .inputs(OreDictUnifier.get(plate, TantalumHafniumSeaborgiumCarbide, 8))
                .inputs(OreDictUnifier.get(plate, Einsteinium.getMaterial(), 8))
                .inputs(FIELD_GENERATOR_UV.getStackForm(2))
                .inputs(HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64))
                .inputs(HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64))
                .inputs(OreDictUnifier.get(wireGtDouble, UVSuperconductor, 64))
                .input(circuit, UEV, 4)
                .input(screw, Trinium, 16)
                .fluidInputs(SolderingAlloy.getFluid(2880 * 2))
                .outputs(GATileEntities.ADVANCED_FUSION_REACTOR.getStackForm())
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(500000)
                .input(wireGtOctal, UVSuperconductor, 4)
                .input(plate, TantalumHafniumSeaborgiumCarbide, 2)
                .input(plate, Einsteinium.getMaterial(), 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(4))
                .input(circuit, MarkerMaterials.Tier.Infinite)
                .inputs(FIELD_GENERATOR_UV.getStackForm())
                .fluidInputs(SolderingAlloy.getFluid(144))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_1, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(2000000)
                .input(wireGtOctal, UHVSuperconductor, 4)
                .input(plate, Bohrium, 2)
                .input(plate, Fermium.getMaterial(), 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(6))
                .input(circuit, UEV)
                .inputs(FIELD_GENERATOR_UHV.getStackForm())
                .fluidInputs(SolderingAlloy.getFluid(288))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_2, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(8000000)
                .input(wireGtOctal, UEVSuperconductor, 4)
                .input(plate, Vibranium, 2)
                .input(plate, Mendelevium.getMaterial(), 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(8))
                .input(circuit, UIV)
                .inputs(FIELD_GENERATOR_UEV.getStackForm())
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_3, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(32000000)
                .input(wireGtOctal, UIVSuperconductor, 4)
                .input(plate, HeavyQuarkDegenerateMatter, 2)
                .input(plate, MetastableFlerovium, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(10))
                .input(circuit, UMV)
                .inputs(FIELD_GENERATOR_UIV.getStackForm())
                .fluidInputs(SolderingAlloy.getFluid(1152))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_4, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(128000000)
                .input(wireGtOctal, UMVSuperconductor, 4)
                .input(plate, QCDMatter, 2)
                .input(plate, SuperheavyLAlloy, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(14))
                .input(circuit, UXV)
                .inputs(FIELD_GENERATOR_UMV.getStackForm())
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_5, 4))
                .buildAndRegister();

        //========================================================================

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(500000)
                .input(frameGt, TungstenSteel, 4)
                .input(plate, TungstenSteel, 6)
                .input(plate, Tungsten, 32)
                .input(screw, LithiumTitanate, 16)
                .inputs(ELECTRIC_PUMP_UHV.getStackForm())
                .inputs(SENSOR_UHV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(144))
                .outputs(GAMetaBlocks.DIVERTOR_CASING.getItemVariant(GADivertorCasing.CasingType.DIVERTOR_1, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(2000000)
                .input(frameGt, Iridium, 6)
                .input(plate, Iridium, 8)
                .input(plate, TungstenTitaniumCarbide, 16)
                .input(screw, LithiumTitanate, 32)
                .inputs(ELECTRIC_PUMP_UEV.getStackForm())
                .inputs(SENSOR_UEV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(288))
                .outputs(GAMetaBlocks.DIVERTOR_CASING.getItemVariant(GADivertorCasing.CasingType.DIVERTOR_2, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(8000000)
                .input(frameGt, Osmiridium, 8)
                .input(plate, Osmiridium, 10)
                .input(plate, TitanSteel, 16)
                .input(screw, LithiumTitanate, 64)
                .inputs(ELECTRIC_PUMP_UIV.getStackForm())
                .inputs(SENSOR_UIV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING, 2))
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GAMetaBlocks.DIVERTOR_CASING.getItemVariant(GADivertorCasing.CasingType.DIVERTOR_3, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(32000000)
                .input(frameGt, Naquadria, 12)
                .input(plate, Naquadria, 14)
                .input(plate, BlackTitanium, 16)
                .input(screw, TriniumTitanium, 64)
                .inputs(ELECTRIC_PUMP_UMV.getStackForm())
                .inputs(SENSOR_UMV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING, 4))
                .fluidInputs(SolderingAlloy.getFluid(1152))
                .outputs(GAMetaBlocks.DIVERTOR_CASING.getItemVariant(GADivertorCasing.CasingType.DIVERTOR_4, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(128000000)
                .input(frameGt, EnrichedNaquadahAlloy, 16)
                .input(plate, EnrichedNaquadahAlloy, 16)
                .input(plate, NaquadriaticTaranium, 16)
                .input(screw, MetastableHassium, 64)
                .inputs(ELECTRIC_PUMP_UXV.getStackForm())
                .inputs(SENSOR_UXV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING, 8))
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .outputs(GAMetaBlocks.DIVERTOR_CASING.getItemVariant(GADivertorCasing.CasingType.DIVERTOR_5, 4))
                .buildAndRegister();

        //====================================================================================

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(500000)
                .input(frameGt, StainlessSteel, 8)
                .input(plate, StainlessSteel, 8)
                .input(pipeTiny, Copper, 64)
                .input(screw, LithiumTitanate, 16)
                .inputs(ELECTRIC_PUMP_UHV.getStackForm())
                .inputs(SENSOR_UHV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(144))
                .outputs(GAMetaBlocks.VACUUM_CASING.getItemVariant(GAVacuumCasing.CasingType.VACUUM_1, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(2000000)
                .input(frameGt, TungstenSteel, 16)
                .input(plate, TungstenSteel, 16)
                .input(pipeTiny, StainlessSteel, 64)
                .input(screw, LithiumTitanate, 32)
                .inputs(ELECTRIC_PUMP_UEV.getStackForm())
                .inputs(SENSOR_UEV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(288))
                .outputs(GAMetaBlocks.VACUUM_CASING.getItemVariant(GAVacuumCasing.CasingType.VACUUM_2, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(8000000)
                .input(frameGt, Iridium, 32)
                .input(plate, Iridium, 32)
                .input(pipeTiny, TungstenSteel, 64)
                .input(screw, LithiumTitanate, 64)
                .inputs(ELECTRIC_PUMP_UIV.getStackForm())
                .inputs(SENSOR_UIV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GAMetaBlocks.VACUUM_CASING.getItemVariant(GAVacuumCasing.CasingType.VACUUM_3, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(32000000)
                .input(frameGt, Osmiridium, 48)
                .input(plate, Osmiridium, 48)
                .input(pipeTiny, Ultimet, 64)
                .input(screw, TriniumTitanium, 64)
                .inputs(ELECTRIC_PUMP_UMV.getStackForm())
                .inputs(SENSOR_UMV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(1152))
                .outputs(GAMetaBlocks.VACUUM_CASING.getItemVariant(GAVacuumCasing.CasingType.VACUUM_4, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(128000000)
                .input(frameGt, Naquadria, 64)
                .input(plate, Naquadria, 64)
                .input(pipeTiny, Lafium, 64)
                .input(screw, MetastableHassium, 64)
                .inputs(ELECTRIC_PUMP_UXV.getStackForm())
                .inputs(SENSOR_UXV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .outputs(GAMetaBlocks.VACUUM_CASING.getItemVariant(GAVacuumCasing.CasingType.VACUUM_5, 4))
                .buildAndRegister();

        //========================================================================

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(500000)
                .input(frameGt, StainlessSteel, 8)
                .input(plate, Titanium, 4)
                .input(pipeTiny, Copper, 64)
                .input(screw, LithiumTitanate, 16)
                .inputs(ELECTRIC_PUMP_UHV.getStackForm())
                .inputs(SENSOR_UHV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(144))
                .outputs(GAMetaBlocks.CRYOSTAT_CASING.getItemVariant(GACryostatCasing.CasingType.CRYOSTAT_1, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(2000000)
                .input(frameGt, TungstenSteel, 16)
                .input(plate, Nitinol60, 4)
                .input(pipeTiny, StainlessSteel, 64)
                .input(screw, LithiumTitanate, 32)
                .inputs(ELECTRIC_PUMP_UEV.getStackForm())
                .inputs(SENSOR_UEV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(288))
                .outputs(GAMetaBlocks.CRYOSTAT_CASING.getItemVariant(GACryostatCasing.CasingType.CRYOSTAT_2, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(8000000)
                .input(frameGt, Iridium, 32)
                .input(plate, TungstenTitaniumCarbide, 16)
                .input(pipeTiny, TungstenSteel, 64)
                .input(screw, LithiumTitanate, 64)
                .inputs(ELECTRIC_PUMP_UIV.getStackForm())
                .inputs(SENSOR_UIV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GAMetaBlocks.CRYOSTAT_CASING.getItemVariant(GACryostatCasing.CasingType.CRYOSTAT_3, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(32000000)
                .input(frameGt, Osmiridium, 48)
                .input(plate, TitanSteel, 16)
                .input(pipeTiny, Ultimet, 64)
                .input(screw, TriniumTitanium, 64)
                .inputs(ELECTRIC_PUMP_UMV.getStackForm())
                .inputs(SENSOR_UMV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(1152))
                .outputs(GAMetaBlocks.CRYOSTAT_CASING.getItemVariant(GACryostatCasing.CasingType.CRYOSTAT_4, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(100).EUt(128000000)
                .input(frameGt, Naquadria, 64)
                .input(plate, BlackTitanium, 16)
                .input(pipeTiny, Lafium, 64)
                .input(screw, MetastableHassium, 64)
                .inputs(ELECTRIC_PUMP_UXV.getStackForm())
                .inputs(SENSOR_UXV.getStackForm())
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .outputs(GAMetaBlocks.CRYOSTAT_CASING.getItemVariant(GACryostatCasing.CasingType.CRYOSTAT_5, 4))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().EUt(500000)
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.FUSION_3))
                .input(plate, TantalumHafniumSeaborgiumCarbide, 6)
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().EUt(500000).duration(50)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .input(plate, TungstenTitaniumCarbide, 4)
                .input(frameGt, TungstenTitaniumCarbide)
                .input(pipeSmall, Zeron100, 4)
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.BLANKET_BASE))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().EUt(500000).duration(50)
                .fluidInputs(SolderingAlloy.getFluid(288))
                .input(plate, Beryllium, 16)
                .input(plateDense, Copper, 2)
                .input(plateDense, StainlessSteel, 2)
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.BLANKET_BASE))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.FUSION_BLANKET))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().EUt(500000).duration(50)
                .fluidInputs(SolderingAlloy.getFluid(288))
                .input(plate, LithiumTitanate, 4)
                .input(plateDense, Copper, 2)
                .input(plateDense, StainlessSteel, 2)
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.BLANKET_BASE))
                .outputs(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.BREEDING_BLANKET))
                .buildAndRegister();
    }
}
