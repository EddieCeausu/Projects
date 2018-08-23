-- @Author: Edmond Ceausu
-- @Date:   2018-08-03T01:44:55-04:00
-- @Email:  eddieswim101@gmail.com
-- @Filename: HelloWorld.hs
-- @Copyright: © Edmond Ceausu 2018
main = do
  putStrLn ("Enter a word: ")
  name <- getLine
  putStrLn ("Hello " ++ name ++ " World!")
