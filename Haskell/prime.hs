sieve xs = sieve' xs map.empty
  where
    sieve' []     table = []
    sieve' (x:xs) table =
        case map.lookup x table of
            Nothing     -> x : sieve' xs (map.insert (x*x) [x] table)
            Just facts  -> sieve' xs (foldl reinsert (map.delete x table) facts)
          where
            reinsert table prime = map.insertWith (++) (x+prime) [prime] table

