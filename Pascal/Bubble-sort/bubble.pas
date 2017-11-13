program bubble;
  var
    list: array[0 .. 9] of real;
    i, j, n: integer;
    t: real;
  begin
    n:= length(list);
    for i := n downto 2 do
      for j := 0 to i - 1 do
        if list[j] > list[j + 1] then
          begin
            t := list[j]
            list[j] := list[j + 1];
            list[j + 1] := t;
            end;
end;
