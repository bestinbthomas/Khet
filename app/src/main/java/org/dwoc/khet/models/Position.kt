package org.dwoc.khet.models

import org.dwoc.khet.GRID_HEIGHT
import org.dwoc.khet.GRID_WIDTH


data class Position(var x: Int, var y: Int) {
  override fun equals(other: Any?): Boolean {
    if (other !is Position || other == null) return false
    return this.x == other.x && this.y == other.y
  }

  fun checkX(other: Position): Boolean =
    this.x == other.x


  fun checkY(other: Position): Boolean =
    this.x == other.x


  operator fun plus(other: Position): Position =
    Position(this.x + other.x, this.y + other.y)

  fun checkLimits(): Boolean =
    x in 0..GRID_WIDTH && y in 0..GRID_HEIGHT

  override fun hashCode(): Int {
    return x * 10 + y
  }
}
