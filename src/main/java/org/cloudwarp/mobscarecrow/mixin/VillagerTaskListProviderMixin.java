package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.ai.brain.task.VillagerTaskListProvider;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerProfession;
import org.cloudwarp.mobscarecrow.goals.GoToNearbyScarecrowTask;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerTaskListProvider.class)
public class VillagerTaskListProviderMixin {
	//Pair.of(new GoToNearbyPositionTask(MemoryModuleType.JOB_SITE, 0.4f, 1, 10), 5)

	@Inject(at = @At("RETURN"), method = "createCoreTasks(Lnet/minecraft/village/VillagerProfession;F)Lcom/google/common/collect/ImmutableList;", cancellable = true)
	private static void createCoreTasks (VillagerProfession profession, float speed, CallbackInfoReturnable<ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>>> cir) {
		cir.setReturnValue(ImmutableList.<Pair<Integer, ? extends Task<? super VillagerEntity>>>builder().addAll(cir.getReturnValue()).add(Pair.of(5, new GoToNearbyScarecrowTask(MSMemoryModules.ATTRACTIVE_SCARECROW, 0.8f, 1, 10))).build());
	}

}
