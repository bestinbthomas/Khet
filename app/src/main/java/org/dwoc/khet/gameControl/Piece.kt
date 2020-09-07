package org.dwoc.khet.gameControl

/*
MIT License

Copyright (c) 2020 Bestin B Thomas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

// Each Types of Piece will Extend this Piece Class
abstract class Piece(val PlayerId : Player , var PosX : Int, var PosY : Int, var Orientation : Direction)
{

  //Function MovePiece will set the PosX and PosY of the Piece
  fun MovePiece (PosX : Int,PosY : Int)
  {
    this.PosX = PosX
    this.PosY = PosY
  }

  //Function RotatePiece will Rotate the Piece's Orientation by the Said Amount
  fun RotatePiece (amount : Int)
  {
     var value: Int = amount + Orientation.ordinal
     value =
       if(value < 0 )
       {
         value + 4
       }
       else
       {
         value % 4
       }
    Orientation = Direction.values()[value]
  }
}

