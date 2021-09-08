package io.github.palexdev.virtualizedfx.cell;

import javafx.scene.Node;

/**
 * Base API for all cells.
 * <p>
 * Also offers a static method to quickly wrap a node into a cell.
 */
public interface Cell {

    /**
     * Wraps the given node is a Cell.
     */
    static <N extends Node> Cell wrapNode(N node) {
        return new Cell() {

            @Override
            public N getNode() { return node; }

            @Override
            public String toString() { return node.toString(); }
        };
    }

    /**
     * Returns the cell's node.
     * The ideal way to implement a cell would be to extend a JavaFX's pane/region
     * and override this method to return "this".
     */
    Node getNode();

    /**
     * Automatically called by the VirtualFlow.
     * <p>
     * Cells are dummy, they have no logic, no state nothing.
     * This method allow cells implementations to keep track of a cell's index.
     * <p>
     * Default implementation is empty.
     */
    default void updateIndex(int index) {}

    /**
     * Automatically called after the cell has been laid out.
     * <p>
     * Default implementation is empty.
     */
    default void afterLayout() {}

    /**
     * Automatically called before the cell is laid out.
     * <p>
     * Default implementation is empty.
     */
    default void beforeLayout() {}

    /**
     * Automatically called before the cell's node is removed from the container.
     * <p>
     * Default implementation is empty.
     */
    default void dispose() {}
}
