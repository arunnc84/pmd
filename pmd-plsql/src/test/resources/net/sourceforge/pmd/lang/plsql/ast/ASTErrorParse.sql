SELECT value
  FROM ACCOUNTABLE
  WHERE (SELECT foo
         FROM DUAL) is null;