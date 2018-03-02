package org.eclipse.wb.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Window;

/**
 * Focus traversal policy based on array of components.
 *
 */
public class FocusTraversalOnArray extends FocusTraversalPolicy {
	private final Component components[];

	/**
	 * Create the focus traversal policy
	 *
	 * @param components
	 */
	public FocusTraversalOnArray(Component components[]) {
		this.components = components;
	}

	private Component cycle(Component currentComponent, int delta) {
		int index = -1;
		for (int i = 0; i < components.length; i++) {
			final Component component = components[i];
			if (component == currentComponent) {
				index = i;
				break;
			}
		}
		// try to find enabled component in "delta" direction
		final int initialIndex = index;
		while (true) {
			final int newIndex = indexCycle(index, delta);
			if (newIndex == initialIndex)
				break;
			index = newIndex;
			//
			final Component component = components[newIndex];
			if (component != null && component.isEnabled() && component.isVisible())
				return component;
		}
		// not found
		return currentComponent;
	}

	@Override
	public Component getComponentAfter(Container container, Component component) {
		return cycle(component, 1);
	}

	@Override
	public Component getComponentBefore(Container container, Component component) {
		return cycle(component, -1);
	}

	@Override
	public Component getDefaultComponent(Container container) {
		return getFirstComponent(container);
	}

	@Override
	public Component getFirstComponent(Container container) {
		if (components != null && components.length > 0)
			return components[0];
		else
			return null;
	}

	@Override
	public Component getInitialComponent(Window window) {
		return getFirstComponent(window);
	}

	@Override
	public Component getLastComponent(Container container) {
		if (components == null || components.length < 1)
			return null;
		return components[components.length - 1];
	}

	private int indexCycle(int index, int delta) {
		final int size = components.length;
		if (size == 0)
			return index;
		final int next = ((index + delta) + size) % size;
		return next;
	}
}