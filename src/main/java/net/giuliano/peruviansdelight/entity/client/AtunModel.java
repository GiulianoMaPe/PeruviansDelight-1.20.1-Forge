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

		PartDefinition atun = partdefinition.addOrReplaceChild("atun", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition bone = atun.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cabeza = bone.addOrReplaceChild("cabeza", CubeListBuilder.create().texOffs(32, 39).addBox(-2.0F, -7.0F, -24.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 9.0F));

		PartDefinition torso = bone.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(5, 41).addBox(-3.0F, -10.0F, -10.0F, 6.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(50, 55).addBox(0.0F, -14.0F, -7.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(7, 2).addBox(0.0F, -15.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition aletaAnal_r1 = torso.addOrReplaceChild("aletaAnal_r1", CubeListBuilder.create().texOffs(7, 2).addBox(0.0F, -7.0F, -3.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition aletaPelvica2_r1 = torso.addOrReplaceChild("aletaPelvica2_r1", CubeListBuilder.create().texOffs(53, 58).addBox(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(53, 58).addBox(1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -1.2217F, 0.0F, 0.0F));

		PartDefinition aletaPectoral2_r1 = torso.addOrReplaceChild("aletaPectoral2_r1", CubeListBuilder.create().texOffs(50, 56).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -5.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition aletaPectoral1_r1 = torso.addOrReplaceChild("aletaPectoral1_r1", CubeListBuilder.create().texOffs(50, 56).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, -5.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cola = bone.addOrReplaceChild("cola", CubeListBuilder.create().texOffs(13, 49).addBox(-3.0F, -8.0F, 0.0F, 6.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(54, 53).addBox(0.0F, -9.0F, 0.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(54, 53).addBox(0.0F, 2.0F, 0.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-2.0F, -6.0F, 5.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(0.0F, -10.0F, 5.0F, 0.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(((AtunEntity) entity).idleAnimationState, ModAnimationDefinitions.ATUN_IDLE, ageInTicks, 1f);
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