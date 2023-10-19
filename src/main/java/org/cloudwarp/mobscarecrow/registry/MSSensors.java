package org.cloudwarp.mobscarecrow.registry;

import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.mixin.SensorTypeAccessor;
import org.cloudwarp.mobscarecrow.sensors.AttractiveScarecrowSensor;
import org.cloudwarp.mobscarecrow.sensors.ScarecrowSensor;

public class MSSensors {
	public static final SensorType<ScarecrowSensor> SCARECROW_SENSOR = Registry.register(Registries.SENSOR_TYPE, MobScarecrow.id("scarecrow_sensor"), SensorTypeAccessor.createSensorType(ScarecrowSensor::new));
	public static final SensorType<AttractiveScarecrowSensor> ATTRACTIVE_SCARECROW_SENSOR = Registry.register(Registries.SENSOR_TYPE, MobScarecrow.id("attractive_scarecrow_sensor"), SensorTypeAccessor.createSensorType(AttractiveScarecrowSensor::new));
	public static void init(){}
}
