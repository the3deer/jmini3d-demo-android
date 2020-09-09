package jmini3d.android.demo.geometry;

import jmini3d.Vector3;

public class BoxGeometry extends VariableGeometry {

	public BoxGeometry(float radius) {
		super(24, 12);
		addBox(new Vector3(-radius, -radius, radius), new Vector3(radius, -radius, radius), //
				new Vector3(-radius, -radius, -radius), new Vector3(radius, -radius, -radius), //
				new Vector3(-radius, radius, radius), new Vector3(radius, radius, radius), //
				new Vector3(-radius, radius, -radius), new Vector3(radius, radius, -radius));
	}
}
