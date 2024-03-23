package net.giuliano.peruviansdelight.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.giuliano.peruviansdelight.entity.animations.ModAnimationDefinitions;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class AtunModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart atun;

	public AtunModel(ModelPart root) {
		this.atun = root.getChild("atun");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition atun = partdefinition.addOrReplaceChild("atun", CubeListBuilder.create(), PartPose.offset(2.0F, 20.0F, 0.0F));

		PartDefinition bone = atun.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-1.5F, 4.0F, -5.0F));

		PartDefinition mitad1 = bone.addOrReplaceChild("mitad1", CubeListBuilder.create().texOffs(44, 0).addBox(-4.0F, -9.0F, -6.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -10.0F, -1.0F, 7.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-1.5F, -15.0F, 1.0F, 0.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(27, 43).addBox(-1.5F, 0.0F, 9.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.903F, 0.0F, -7.0605F));

		PartDefinition cube_r1 = mitad1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -4.0F, 6.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r2 = mitad1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, 6.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition aleta2_r1 = mitad1.addOrReplaceChild("aleta2_r1", CubeListBuilder.create().texOffs(6, 40).addBox(0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition aleta1_r1 = mitad1.addOrReplaceChild("aleta1_r1", CubeListBuilder.create().texOffs(0, 40).addBox(0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition mitad2 = bone.addOrReplaceChild("mitad2", CubeListBuilder.create().texOffs(0, 25).addBox(-3.5F, -10.0F, 0.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(44, 13).addBox(-2.5F, -9.0F, 8.0F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(31, 17).addBox(0.0F, -12.0F, 2.0F, 0.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.403F, 0.0F, 6.9395F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		if (!entity.isInWater()) {
			this.animate(((AtunEntity) entity).idleAnimationState, ModAnimationDefinitions.ATUN_FUERA, ageInTicks, 1f);
		} else {
			this.animate(((AtunEntity) entity).idleAnimationState, ModAnimationDefinitions.ATUN_IDLE, ageInTicks, 1f);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		atun.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return atun;
	}
}