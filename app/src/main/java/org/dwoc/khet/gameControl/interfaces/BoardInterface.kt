package org.dwoc.khet.gameControl.interfaces

import androidx.lifecycle.LiveData
import org.dwoc.khet.gameControl.Piece
import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Player
import java.time.temporal.TemporalAmount

interface BoardInterface {
  //the positions the selected piece can move to (to be highlighted by the UI)
  val highlightPositions: LiveData<List<Position>>

  // the selected pieve
  val selectedPiece: LiveData<Piece?>

  //the path traversed by the laser
  val laserPath: LiveData<List<Position>>

  val currentPlayer: LiveData<Player>

  //to get the piece selected by the user
  fun getPiece(position: Position): Piece?

  //general function to be called when user clicks on the board
  fun onClick(position: Position)

  //to get and highlight the available positions of the selected piece
  fun selectPiece(position: Position)

  //reset selection to null (to be used after the move or cancel the move)
  fun resetSelection()

  // rotate a piece
  fun rotatePiece(amount: Int)

  //gets triggered when user shoots the laser
  fun shootLaser(player: Player)

  // reset the laser path
  fun resetLaser()

  //to get the status of the selected piece
  fun getState(): List<Piece>

  //complete the move and trigger the laser
  fun completeMove()

}
