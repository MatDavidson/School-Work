/*These are queries I used to get my results as well as test to see if my tallest was actually tallest.
SELECT ilkid, h_feet, h_inches FROM players;
SELECT * FROM players WHERE ilkid = "ABDELAL01";
SELECT ilkid, h_feet, h_inches FROM players WHERE h_feet > 6;*/

/* I tried using the following query to grab the tallest player but it returns nothing. My logic is probably incorrect.
SELECT * FROM players WHERE h_feet = (SELECT MAX(h_feet) FROM players) AND h_inches = (SELECT MAX(h_inches) FROM players);*/

/* This is the statement I used to solve problem 2. 
SELECT * FROM coaches_career WHERE season_win = (SELECT MAX(season_win) FROM coaches_career);*/

/* This is the statement I used to solve problem 3.
SELECT * FROM teams WHERE location = "San Diego";*/
