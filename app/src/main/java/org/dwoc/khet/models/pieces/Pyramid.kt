package org.dwoc.khet.models.pieces

import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.enums.Type

class Pyramid(PlayerId: Player, Position: Position, Orientation: Direction) :
  Piece(Type.PHARAOH, PlayerId, Position, Orientation) {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {
    val reflectedDirection: Direction? = when (rayDirection) {
      Direction.NORTH -> when (Orientation) {
        Direction.NORTH -> Direction.EAST
        Direction.WEST -> Direction.WEST
        else -> null
      }
      Direction.EAST -> when (Orientation) {
        Direction.NORTH -> Direction.NORTH
        Direction.EAST -> Direction.SOUTH
        else -> null
      }
      Direction.SOUTH -> when (Orientation) {
        Direction.EAST -> Direction.EAST
        Direction.SOUTH -> Direction.WEST
        else -> null
      }
      Direction.WEST -> when (Orientation) {
        Direction.SOUTH -> Direction.SOUTH
        Direction.WEST -> Direction.NORTH
        else -> null
      }
    }
    val hit = (reflectedDirection == null)

    return Pair(hit, reflectedDirection)
  }

  override val canReplace: Boolean
    get() = false
}
