Basic Layout
============

The file is a simple text file with a keyword at the start of the line.

Each line must start with the following keywords:

* Background 
* Player1
* Player2
* Barrier


All these arguments are optional. So if you don't wish to include a background,
you can omit its use.

You can also include as many barriers as you wish, one per line.


Background
==========
Background [image_filename]

The background image with the [image_filename] as the background. As of this time
this does not seem to be working 100%

Player1 & Player 2
==================
Player [x_pos] [y_pos] [default_player_image] [north] [north_east] [east] [south_east] [south] [south_west] [west] [ north_west] [bullet]

* x_pos - The x starting position
* y_pos - The y starting position
* default_player_image - The default image for the player
* north.... - The image for the player facing the cardinal point
* bullet - The image representing the bullet being shot by this player.

The starting position is for the top left corner of the player.

Barrier
=======
Barrier [x_pos] [y_pos] [barrier_image]

* x_pos - The x starting position
* y_pos - The y starting position
* barrier_image - The image for the barrier.

The image will define how big the barrier will be. The starting position is
for the top left.