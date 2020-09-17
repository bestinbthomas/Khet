package org.dwoc.khet.gameControl.interfaces

import org.dwoc.khet.gameControl.Piece

public interface BoardInterface {

  //to get the piece selected by the user
  fun getPiece(PosX: Int,PosY: Int)

  //to get and highlight the available positions of the selected piece
  fun getAvailablePositions(list: List<Int>)

  //gets triggered when user shoots the laser
  fun ShootLaser(Player: Int,Orientation: Int)

  //to get the status of the selected piece
  fun getState(List: Array<Piece>)

}
