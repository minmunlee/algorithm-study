SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE UPPER(NAME) LIKE "%EL%" AND ANIMAL_TYPE = "Dog"
ORDER BY UPPER(NAME)