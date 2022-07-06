package org.cloudwarp.mobscarecrow.utils;

import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

import java.util.HashSet;

public interface ScarecrowAccess {
	void addScarecrow(SmallPlushieEntity scarecrow, HashSet<SmallPlushieEntity> list);

	HashSet<SmallPlushieEntity> getScaryScarecrows ();
	HashSet<SmallPlushieEntity> getAttractiveScarecrows ();

	void removeScarecrow(SmallPlushieEntity scarecrow, HashSet<SmallPlushieEntity> list);
}
