data Direction = E | S | W | N deriving (Show, Enum, Read)
data Instruction = L | R | M deriving (Read)
data Position = Position Int Int Direction
type RoverData = (Position, Instructions)
type GridSize = (Int,Int)
type Instructions = String

instance Show Position where show (Position x y d) = show x ++ " " ++ show y ++ " " ++ show d ++ " "

main = do
    gridSizeStr:roverDataInputStrs <- lines <$> getContents
    let gridSize = let [gx, gy] = words gridSizeStr in (read gx,read gy)
        changedRoverPositions = map (moveRover gridSize) $ interpret roverDataInputStrs
    mapM_ (putStr . show) $ changedRoverPositions; putStrLn ""

interpret :: [String] -> [RoverData]
interpret [] = []
interpret (posStr:instStr:remaining) = let [x, y, d] = words posStr
                                       in (Position (read x) (read y) (read d), instStr):interpret remaining

moveRover :: GridSize -> RoverData -> Position
moveRover gridSize (roverPosition, ins) = foldl (\acc x -> nextPosition gridSize acc (read [x])) roverPosition ins

nextPosition :: GridSize -> Position -> Instruction -> Position
nextPosition gridSize p M = driveForward gridSize p
nextPosition gridSize (Position px py dir) instn = Position px py (changeDirection dir instn)

driveForward :: GridSize -> Position -> Position
driveForward (gx, _) (Position px py E) | px < gx = Position (px+1) py E
driveForward _ (Position px py S) | py > 0 = Position px (py-1) S
driveForward _ (Position px py W)  | px > 0 = Position (px-1) py W
driveForward (_, gy) (Position px py N) | py < gy = Position px (py+1) N
driveForward (_,_) p = p

changeDirection :: Direction -> Instruction -> Direction
changeDirection E L = N
changeDirection N R = E
changeDirection dir L = pred dir
changeDirection dir R = succ dir
