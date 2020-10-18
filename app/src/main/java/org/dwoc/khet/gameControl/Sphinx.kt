package org.dwoc.khet.gameControl

import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player

class Sphinx(PlayerId: Player, PosX: Int, PosY: Int, Orientation: Direction) :
  Piece(PlayerId, PosX, PosY, Orientation) {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {
    return Pair(false, Direction.values()[Orientation.ordinal])
  }
}
