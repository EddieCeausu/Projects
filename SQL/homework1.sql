select MECHNAME, AGE from MECHANIC;

select AIRNAME, STATE, SIZ, YEAROPENED from AIRPORT
where STATE='CA' and SIZ >= 20 and YEAROPENED >= 1935
order by siz ASC;

begin
    DBMS_OUTPUT.put_line('c');
end;
/
select AIRNAME, SIZ, YEAROPENED, STATE from AIRPORT
where STATE='CA' and (SIZ >= 20 or YEAROPENED >= 1935);

begin
    DBMS_OUTPUT.put_line('d');
end;
/
select AVG(SIZ) from AIRPORT
where STATE='CA' and YEAROPENED >= 1935;

begin
    DBMS_OUTPUT.put_line('e');
end;
/
select COUNT(AIRNAME) from AIRPORT
where STATE='CA' and YEAROPENED >= 1935;

begin
    DBMS_OUTPUT.put_line('f');
end;
/
select COUNT(AIRNAME) from AIRPORT
where YEAROPENED >= 1935;
group by STATE;

begin
    DBMS_OUTPUT.put_line('g');
end;
/
select COUNT(AIRNAME), STATE from AIRPORT
where YEAROPENED >= 1935
group by STATE
having COUNT(AIRNAME) >= 5;

begin
    DBMS_OUTPUT.put_line('h');
end;
/
select MECHNAME, STATE from MECHANIC, AIRPORT
where MECHANIC.AIRNAME = AIRPORT.AIRNAME and STATE='CA';

begin
    DBMS_OUTPUT.put_line('i');
end;
/
select MECHNAME from SKILL, QUALIFICATION, MECHANIC
where SKILL.SKILLNUM = QUALIFICATION.SKILLNUM and QUALIFICATION.MECHNUM = MECHANIC.MECHNUM and (PROFRATE=4 and SKILLNAME='fan blade replacement');

begin
    DBMS_OUTPUT.put_line('j');
end;
/
select MECHNAME from SKILL, QUALIFICATION, MECHANIC, AIRPORT
where SKILL.SKILLNUM = QUALIFICATION.SKILLNUM AND QUALIFICATION.MECHNUM = MECHANIC.MECHNUM and (MECHANIC.AIRNAME = AIRPORT.AIRNAME and AIRPORT.STATE = 'CA') and (PROFRATE=4 AND SKILLNAME='fan blade replacement');

begin
    DBMS_OUTPUT.put_line('k');
end;
/
select AIRPORT.CITY, SUM(SALARY) from MECHANIC, AIRPORT
where MECHANIC.AIRNAME = AIRPORT.AIRNAME
group by AIRPORT.CITY;

begin
    DBMS_OUTPUT.put_line('l');
end;
/
select MAX(SIZ) as LARGEST_AIRPORT
from AIRPORT;

begin
    DBMS_OUTPUT.put_line('m');
end;
/
select MAX(SIZ) as LARGEST_AIRPORT
from AIRPORT where STATE = 'CA';
