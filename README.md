## Conway's Game of Life by Java

The code simulate [Conway's game of life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life), player can designate world size and number of generations.

#### build
``` shell
> ./gradlew jar
```

Find `jar` file at build/libs.

#### usage
``` shell
> java -jar xxx.jar [size] [round]
```

The game world is a n*n square, so the argument `size` stands for square length, the argument `round` means the total generations of evolution.
