package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 方块因为世界条件消退，融化，消失的事件
 * <p>
 * 例如:
 * <ul>
 * <li>雪被附近的光源融化
 * <li>冰被附近的光源融化
 * <li>火燃烧后破坏可以作为燃料的方块
 * </ul>
 * <p>
 * 这事件被取消, 方块不会因为世界条件消退，融化，消失
 */
public class BlockFadeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final BlockState newState;

    public BlockFadeEvent(final Block block, final BlockState newState) {
        super(block);
        this.newState = newState;
        this.cancelled = false;
    }

    /**
     * 获取因为世界条件消退，融化，消失的事件的方块状态
     *
     * @return 因为世界条件消退，融化，消失的事件的方块状态
     */
    public BlockState getNewState() {
        return newState;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
